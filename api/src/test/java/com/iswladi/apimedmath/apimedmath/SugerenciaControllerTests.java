package com.iswladi.apimedmath.apimedmath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SugerenciaControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
    /**
     * Test para verificar que se retornen sugerencias de horarios válidas
     */
	void debeRetornarSugerenciasValidas() throws Exception {
        String jsonContent = "{ \"cadaCuantoHoras\": 8, \"porCuantosDias\": 20 }";
		this.mockMvc.perform(get("/obtener/sugerencia/horarios")
            .content(jsonContent).contentType(MediaType.APPLICATION_JSON)).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.porCuantosDias").value(20))
            .andExpect(jsonPath("$.cadaCuantoHoras").value(8))
            .andExpect(jsonPath("$.cuantasVecesTomarPorDia").value(3))
            .andExpect(jsonPath("$.sugerenciaHorarios[0][0]").value("00:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[0][1]").value("08:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[0][2]").value("16:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[1][0]").value("01:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[1][1]").value("09:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[1][2]").value("17:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[2][0]").value("02:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[2][1]").value("10:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[2][2]").value("18:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[3][0]").value("03:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[3][1]").value("11:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[3][2]").value("19:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[4][0]").value("04:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[4][1]").value("12:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[4][2]").value("20:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[5][0]").value("05:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[5][1]").value("13:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[5][2]").value("21:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[6][0]").value("06:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[6][1]").value("14:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[6][2]").value("22:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[7][0]").value("07:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[7][1]").value("15:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[7][2]").value("23:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[8][0]").value("08:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[8][1]").value("16:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[8][2]").value("00:00 am"));

        jsonContent = "{ \"cadaCuantoHoras\": 12, \"porCuantosDias\": 5 }";
		this.mockMvc.perform(get("/obtener/sugerencia/horarios")
            .content(jsonContent).contentType(MediaType.APPLICATION_JSON)).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.porCuantosDias").value(5))
            .andExpect(jsonPath("$.cadaCuantoHoras").value(12))
            .andExpect(jsonPath("$.cuantasVecesTomarPorDia").value(2))
            .andExpect(jsonPath("$.sugerenciaHorarios[0][0]").value("00:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[0][1]").value("12:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[1][0]").value("01:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[1][1]").value("13:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[2][0]").value("02:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[2][1]").value("14:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[3][0]").value("03:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[3][1]").value("15:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[4][0]").value("04:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[4][1]").value("16:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[5][0]").value("05:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[5][1]").value("17:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[6][0]").value("06:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[6][1]").value("18:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[7][0]").value("07:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[7][1]").value("19:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[8][0]").value("08:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[8][1]").value("20:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[9][0]").value("09:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[9][1]").value("21:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[10][0]").value("10:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[10][1]").value("22:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[11][0]").value("11:00 am"))
            .andExpect(jsonPath("$.sugerenciaHorarios[11][1]").value("23:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[12][0]").value("12:00 pm"))
            .andExpect(jsonPath("$.sugerenciaHorarios[12][1]").value("00:00 am"));
	}
}
