package com.astropay.manager;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.astropay.controller.ManagerController;
import com.astropay.dto.ObtenerPostResponseDTO;

/**
 * Controlador de Manager
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagerController.class)
@AutoConfigureMockMvc
public class ObtenerListadoPostUnitTest {

	private static final Logger logger = Logger.getLogger(ObtenerListadoPostUnitTest.class.getName());
	
	@MockBean
	private ManagerController managerController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void obtenerListadoPost(Pageable pageable) throws Exception {
		logger.log(Level.INFO, "TEST -> ObtenerListadoPostTest");
		
		List<ObtenerPostResponseDTO> listPostDTO = List.of(
				new ObtenerPostResponseDTO(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"), 
				new ObtenerPostResponseDTO(1, 2, "qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"), 
				new ObtenerPostResponseDTO(1, 3, "ea molestias quasi exercitationem repellat qui ipsa sit aut", "et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut")
				);

		when(managerController.obtenerListadoPosts(pageable)).thenReturn(ResponseEntity.ok(listPostDTO));
		mockMvc.perform(get("/manager")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}