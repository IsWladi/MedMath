package com.iswladi.apimedmath.apimedmath.Controllers;

import java.util.ArrayList;

import com.iswladi.apimedmath.apimedmath.Entities.Receta;
import com.iswladi.apimedmath.apimedmath.Entities.Sugerencia;
import com.iswladi.apimedmath.apimedmath.Repositories.SugerenciaRepository;
import com.iswladi.apimedmath.apimedmath.exception.RequestException;
import com.iswladi.apimedmath.apimedmath.utils.ConfiguracionSugerencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SugerenciaController
 */
@RestController
public class SugerenciaController {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    /**
     * Endpoint para obtener una sugerencia de horarios basada en la receta proporcionada.
     *
     * @param receta La receta que contiene la información necesaria para calcular los horarios.
     * @param horaInicioDia La hora en la que se inicia el dia del usuario (alarma para despertar).
     * @return Un objeto Sugerencia que incluye los horarios sugeridos, cada cuánto tiempo tomar y por cuántos días.
     */
    @GetMapping("/obtener/sugerencia/horarios")
    public ResponseEntity<?> obtenerSugerenciaHorarios(
            @RequestBody Receta receta,
            @RequestParam(value = "horaInicioDia", required = false, defaultValue = "0") int horaInicioDia ) {

        // Definir configuracion del usuario para las sugerencias
        // En cada argumento a setear se hace manejo de errores
        ConfiguracionSugerencia configuracionSugerencia = new ConfiguracionSugerencia.Builder()
            .horaInicioDia(horaInicioDia)
            .build();

        int cuantasVecesTomarPorDia = this.calcularCuantasVecesTomarDia(receta.getCadaCuantoHoras());

        ArrayList<ArrayList<String>> sugerenciaHorarios = this.obtenerSugerenciaHorarios(cuantasVecesTomarPorDia, receta, configuracionSugerencia);
        Sugerencia sugerencias = new Sugerencia(sugerenciaHorarios, receta.getCadaCuantoHoras(), receta.getPorCuantosDias(), cuantasVecesTomarPorDia);
        return new ResponseEntity<>(sugerencias, HttpStatus.OK);
    }

    /**
     * Metodo que implementa la lógica para obtener una sugerencia de horarios.
     *
     * @param cuantasVecesTomarPorDia Numero de veces a tomar por dia la receta.
     * @param receta La receta que contiene la información necesaria para calcular los horarios.
     * @return Retorna una lista de sugerencias de horarios basada en la receta proporcionada.
     */
    public ArrayList<ArrayList<String>> obtenerSugerenciaHorarios(int cuantasVecesTomarPorDia, Receta receta, ConfiguracionSugerencia configuracionSugerencia){
        // se debe devolver una lista de horarios en formato de 24 horas
        ArrayList<ArrayList<String>> sugerenciaHorarios = new ArrayList<ArrayList<String>>();
        int ultimaHoraPosibleTomarDosis = (receta.getCadaCuantoHoras() * cuantasVecesTomarPorDia) - (receta.getCadaCuantoHoras() * (cuantasVecesTomarPorDia - 1));

        if (configuracionSugerencia.getHoraInicioDia() > ultimaHoraPosibleTomarDosis) {
            String mensajeError = "horaInicioToma (" + configuracionSugerencia.getHoraInicioDia() + ") no puede ser mayor a la ultima hora posible de tomar la dosis final del día (" + ultimaHoraPosibleTomarDosis + ").";
            throw new RequestException(HttpStatus.BAD_REQUEST, mensajeError);
        }

        for (int i = configuracionSugerencia.getHoraInicioDia(); i < 24; i++) {
            ArrayList<String> sugerenciaList = new ArrayList<String>();

            // crear sugerencia de horario empezando en hora "i"
            int j = i;
            int cantidadVecesTomadas = 0; // para saber cuantas sugerencias se han hecho
            boolean esSugerenciasValida = true;
            while (cantidadVecesTomadas < cuantasVecesTomarPorDia) {
                String horaSugerida = this.convertirHoraIntAString(j);
                // si la hora sugerida es mayor a 00:00, es una sugerencia invalida
                if (j > 24) {
                    esSugerenciasValida = false;
                    break;
                }
                sugerenciaList.add(horaSugerida);
                j += receta.getCadaCuantoHoras();
                cantidadVecesTomadas++;
            }
            if (esSugerenciasValida) {
                sugerenciaHorarios.add(sugerenciaList);
            }
            else {
                break;
            }
        }

        return sugerenciaHorarios;


    }

    /**
     * Método que hace la conversión de un entero a un string con formato de hora 24 horas (15 -> 15:00 pm)
     *
     * @param hora La hora en entero que se quiere convertir a string.
     * @return Retorna la hora en formato de string.
     */
    public String convertirHoraIntAString(int hora) {
        String horaString = String.valueOf(hora);
        if (horaString.length() == 1) {
            horaString = "0" + horaString;
        }
        if (horaString.equals("24")) {
            horaString = "00";
        }
        horaString += ":00";
        // agregar si es AM o PM
        if (hora < 12 || hora == 24) {
            horaString += " am";
        }
        else {
            horaString += " pm";
        }
        return horaString;
    }


    /**
     * Método que calcula cuántas veces se debe tomar el medicamento durante el día.
     *
     * @param cadaCuantoHoras La cantidad de horas que deben pasar entre cada toma.
     * @return Retorna la hora en formato de string.
     */
    public int calcularCuantasVecesTomarDia(int cadaCuantoHoras) {
        // return 0: error, no puede ser mayor a 24 horas o menor o igual a 0 horas
        if (cadaCuantoHoras >24 || cadaCuantoHoras <= 0) {
            return 0;
        }
        return 24 / cadaCuantoHoras;
    }
}
