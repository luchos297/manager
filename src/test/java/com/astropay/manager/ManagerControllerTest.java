package com.astropay.manager;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.astropay.dto.GuardarPostRequestDTO;
import com.astropay.dto.ObtenerPostCommentResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ManagerController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class ManagerControllerTest {

	@MockBean
	private ManagerController managerController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void obtenerListadoPost(Pageable pageable) throws Exception {
		List<ObtenerPostResponseDTO> listPostDTO = List.of(
				new ObtenerPostResponseDTO(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"), 
				new ObtenerPostResponseDTO(1, 2, "qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"), 
				new ObtenerPostResponseDTO(1, 3, "ea molestias quasi exercitationem repellat qui ipsa sit aut", "et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut")
				);

		when(managerController.obtenerListadoPosts(pageable)).thenReturn(ResponseEntity.ok(listPostDTO));
		mockMvc.perform(get("/manager")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void obtenerListadoComentarioPost(Pageable pageable) throws Exception {
		List<ObtenerPostCommentResponseDTO> listCommentPostDTO = List.of(
				new ObtenerPostCommentResponseDTO(39, 191, "est perferendis eos dolores maxime rerum qui", "Eugene@mohammed.net", "sit vero aut voluptatem soluta corrupti dolor cum\nnulla ipsa accusamus aut suscipit ut dicta ut nemo\nut et ut sit voluptas modi\nillum suscipit ea debitis aut ullam harum"), 
				new ObtenerPostCommentResponseDTO(39, 192, "sunt veritatis quisquam est et porro nesciunt excepturi a", "Janick@marty.me", "dolore velit autem perferendis hic\\ntenetur quo rerum\\nimpedit error sit eaque ut\\nad in expedita et nesciunt sit aspernatur repudiandae"), 
				new ObtenerPostCommentResponseDTO(39, 193, "quia velit nostrum eligendi voluptates", "Alena@deron.name", "laudantium consequatur sed adipisci a\\nodit quia necessitatibus qui\\nnumquam expedita est accusantium nostrum\\noccaecati perspiciatis molestiae nostrum atque"),
				new ObtenerPostCommentResponseDTO(39, 194, "non ut sunt ut eius autem ipsa eos sapiente", "Alphonso_Rosenbaum@valentin.co.uk", "aut distinctio iusto autem sit libero deleniti\\nest soluta non perferendis illo\\neveniet corrupti est sint quae\\nsed sunt voluptatem"), 
				new ObtenerPostCommentResponseDTO(39, 195, "tempore vel accusantium qui quidem esse ut aut", "Frank@rosalind.name", "culpa voluptas quidem eos quis excepturi\\nquasi corporis provident enim\\nprovident velit ex occaecati deleniti\\nid aspernatur fugiat eligendi")
				);

		when(managerController.obtenerListadoComentarioPost(39, pageable)).thenReturn(ResponseEntity.ok(listCommentPostDTO));
		mockMvc.perform(get("/manager/{idPost}")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

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