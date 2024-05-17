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
        // Implementación de la lógica para obtener sugerencia de horarios
        // para tomar los remedios
        // se debe devolver una lista de horarios en formato de 24 horas
        ArrayList<ArrayList<String>> sugerenciaHorarios = new ArrayList<ArrayList<String>>();

        // Ejemplo de sugerencia de horarios
        ArrayList<String> sugerenciaList = new ArrayList<String>();
        sugerenciaList.add("08:00");
        sugerenciaList.add("12:00");
        sugerenciaList.add("16:00");

        sugerenciaHorarios.add(sugerenciaList);
        // Ejemplo de sugerencia de horarios

        int cadaCuantoHoras = receta.getCadaCuantoHoras();
        int porCuantosDias = receta.getPorCuantosDias();

        Sugerencia sugerencia = new Sugerencia(sugerenciaHorarios, cadaCuantoHoras, porCuantosDias);
        return sugerencia;
    }
}
