package com.astropay.manager;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.astropay.controller.ManagerController;
import com.astropay.dto.GuardarPostRequestDTO;
import com.astropay.dto.ObtenerPostResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ManagerController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class GuardarPostTest {

	@MockBean
	private ManagerController managerController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void guardarPost(Pageable pageable) throws Exception {
		GuardarPostRequestDTO guardarPostRequestDTO = new GuardarPostRequestDTO(49, "Luz: a la espera de la segmentación", "El Gobierno de Mendoza inició el proceso de revisión tarifaria para aplicar aumentos en el Valor Agregado de Distribución.");
		ObtenerPostResponseDTO obtenerPostResponseDTO = new ObtenerPostResponseDTO(73, 49, "Luz: a la espera de la segmentación", "El Gobierno de Mendoza inició el proceso de revisión tarifaria para aplicar aumentos en el Valor Agregado de Distribución.");
		
		ObjectMapper mapper = new ObjectMapper();

		when(managerController.guardarPost(guardarPostRequestDTO)).thenReturn(ResponseEntity.ok(obtenerPostResponseDTO));
		String jsonRequest = mapper.writeValueAsString(guardarPostRequestDTO);
		mockMvc.perform(post("/manager").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)).andDo(print()).andExpect(status().isOk());
	}
}