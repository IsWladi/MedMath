package com.iswladi.apimedmath.apimedmath.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.iswladi.apimedmath.apimedmath.Entities.Receta;
import com.iswladi.apimedmath.apimedmath.Entities.Sugerencia;
import com.iswladi.apimedmath.apimedmath.Repositories.SugerenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SugerenciaController
 */
@RestController
public class SugerenciaController {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    @GetMapping("/obtener/sugerencia/horarios")
    public Sugerencia obtenerSugerenciaHorarios(@RequestBody Receta receta) {
        int cuantasVecesTomarPorDia = this.calcularCuantasVecesTomarDia(receta.getCadaCuantoHoras());
        int ultimaHoraPosibleTomar = this.calcularUltimaHoraPosibleTomar(receta.getCadaCuantoHoras());

        // se debe devolver una lista de horarios en formato de 24 horas
        ArrayList<ArrayList<String>> sugerenciaHorarios = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < 24; i++) {
            int ultimaHoraTomarOtra = ((i + receta.getCadaCuantoHoras()) * cuantasVecesTomarPorDia);

            ArrayList<String> sugerenciaList = new ArrayList<String>();

            // crear sugerencia de horario empezando en hora "i"
            int j = i;
            int cantidadVecesTomadas = 0; // para saber cuantas sugerencias se han hecho
            boolean esSugerenciasValida = true;
            while (j <= ultimaHoraTomarOtra && cantidadVecesTomadas < cuantasVecesTomarPorDia) {
                String horaSugerida = this.convertirHoraIntAString(j);
                // si la hora sugerida el mayor a 00:00, es una sugerencia invalida
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


        return new Sugerencia(sugerenciaHorarios, receta.getCadaCuantoHoras(), receta.getPorCuantosDias(), cuantasVecesTomarPorDia);
    }

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

    public int calcularCuantasVecesTomarDia(int cadaCuantoHoras) {
        // return 0: error, no puede ser mayor a 24 horas o menor o igual a 0 horas
        if (cadaCuantoHoras >24 || cadaCuantoHoras <= 0) {
            return 0;
        }
        return 24 / cadaCuantoHoras;
    }

    public int calcularUltimaHoraPosibleTomar(int cadaCuantoHoras) {
        int ultimaHoraPosible = 24 - cadaCuantoHoras;
        return ultimaHoraPosible;
    }
}
