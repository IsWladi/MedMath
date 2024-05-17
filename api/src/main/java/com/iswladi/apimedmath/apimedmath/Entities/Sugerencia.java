package com.iswladi.apimedmath.apimedmath.Entities;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Sugerencia
 */

@Entity
public class Sugerencia extends Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(nullable = false)
    private ArrayList<ArrayList<String>> sugerenciaHorarios;

    public Sugerencia(ArrayList<ArrayList<String>> sugerenciaHorarios, int cadaCuantoHoras, int porCuantosDias) {
        super(cadaCuantoHoras, porCuantosDias);
        this.sugerenciaHorarios = sugerenciaHorarios;
    }

	public Long getId() {
		return id;
	}

	public ArrayList<ArrayList<String>> getSugerenciaHorarios() {
		return sugerenciaHorarios;
	}

	public void setSugerenciaHorarios(ArrayList<ArrayList<String>> sugerenciaHorarios) {
		this.sugerenciaHorarios = sugerenciaHorarios;
	}

}
