package com.iswladi.apimedmath.apimedmath.utils;

import org.springframework.http.HttpStatus;

import com.iswladi.apimedmath.apimedmath.exception.RequestException;

/**
 * ConfiguracionSugerencia
 *
 * Clase que contiene la configuración de las sugerencias de horarios por defecto.
 */
public class ConfiguracionSugerencia {

    private final int horaInicioDia; // hora en la que el usuario suele despertar.

    public ConfiguracionSugerencia(Builder builder) {
        this.horaInicioDia = builder.horaInicioDia;
    }

    public int getHoraInicioDia() {
        return horaInicioDia;
    }

    public static class Builder {
        private int horaInicioDia;

        public ConfiguracionSugerencia.Builder horaInicioDia(int horaInicioDia) {
            if (horaInicioDia < 0) {
                String mensajeError = "horaInicioDia (" + horaInicioDia + ") no puede contener numeros negativos";
                throw new RequestException(HttpStatus.BAD_REQUEST, mensajeError);
            }
            this.horaInicioDia = horaInicioDia;
            return this;
        }

        public ConfiguracionSugerencia build() {
            return new ConfiguracionSugerencia(this);
        }
    }

}
