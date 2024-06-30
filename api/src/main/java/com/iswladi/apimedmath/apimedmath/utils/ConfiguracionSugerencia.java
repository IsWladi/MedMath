package com.iswladi.apimedmath.apimedmath.utils;

import org.springframework.http.HttpStatus;

import com.iswladi.apimedmath.apimedmath.exception.RequestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ConfiguracionSugerencia
 *
 * Clase que contiene la configuración de las sugerencias de horarios por defecto.
 */
public class ConfiguracionSugerencia {

    private final Float horaInicioDia; // hora en la que el usuario suele despertar.

    public ConfiguracionSugerencia(Builder builder) {
        this.horaInicioDia = builder.horaInicioDia;
    }

    public Float getHoraInicioDia() {
        return horaInicioDia;
    }

    public static class Builder {
        private Float horaInicioDia;

        public ConfiguracionSugerencia.Builder horaInicioDia(String horaInicioDia) {
            //validar el patron de la hora
            Pattern pattern = Pattern.compile("^(0?[0-9]|1[0-9]|2[0-3]):([0-5][05])$");
            Matcher matcher = pattern.matcher(horaInicioDia);
            boolean matchFound = matcher.find();
            if (!matchFound) {
                String mensajeError = "horaInicioDia (" + horaInicioDia + ") no tiene el formato correcto";
                throw new RequestException(HttpStatus.BAD_REQUEST, mensajeError);
            }

            //convertir la hora a float
            //11:30 -> 11.30
            //11:05 -> 11.05
            //11:55 -> 11.55
            //00:00 -> 0.0
            //01:00 -> 1.0
            //1:00 -> 1.0
            horaInicioDia = horaInicioDia.replace(":", ".");
            Float horaInicioDiaFloat = Float.parseFloat(horaInicioDia);
            this.horaInicioDia = horaInicioDiaFloat;
            return this;
        }

        public ConfiguracionSugerencia build() {
            return new ConfiguracionSugerencia(this);
        }
    }

}
