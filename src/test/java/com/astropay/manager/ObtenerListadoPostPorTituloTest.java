package com.astropay.manager;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.astropay.controller.ManagerController;
import com.astropay.dto.ObtenerPostResponseDTO;

@WebMvcTest(controllers = ManagerController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class ObtenerListadoPostPorTituloTest {

	@MockBean
	private ManagerController managerController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void obtenerListadoPostPorTitulo(Pageable pageable) throws Exception {
		List<ObtenerPostResponseDTO> listCommentPostPorTituloDTO = List.of(
				new ObtenerPostResponseDTO(5, 43, "eligendi iste nostrum consequuntur adipisci praesentium sit beatae perferendis", "similique fugit est\nillum et dolorum harum et voluptate eaque quidem\nexercitationem quos nam commodi possimus cum odio nihil nulla\ndolorum exercitationem magnam ex et a et distinctio debitis"), 
				new ObtenerPostResponseDTO(6, 52, "qui enim et consequuntur quia animi quis voluptate quibusdam", "iusto est quibusdam fuga quas quaerat molestias\na enim ut sit accusamus enim\ntemporibus iusto accusantium provident architecto\nsoluta esse reprehenderit qui laborum"), 
				new ObtenerPostResponseDTO(8, 73, "consequuntur deleniti eos quia temporibus ab aliquid at", "voluptatem cumque tenetur consequatur expedita ipsum nemo quia explicabo\naut eum minima consequatur\ntempore cumque quae est et\net in consequuntur voluptatem voluptates aut")
				);

		when(managerController.obtenerListadoPostPorTitulo("consequuntur")).thenReturn(ResponseEntity.ok(listCommentPostPorTituloDTO));
		mockMvc.perform(get("/manager/titulo/{titulo}")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}