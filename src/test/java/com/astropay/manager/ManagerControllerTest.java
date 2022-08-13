package com.astropay.manager;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.astropay.dto.ObtenerCommentarioPostResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;
import com.astropay.service.ManagerService;

@SpringBootTest
public class ManagerControllerTest {

	@MockBean
	private ManagerService managerService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void obtenerListadoPost() throws Exception {
		List<ObtenerPostResponseDTO> listPostDTO = List.of(
				new ObtenerPostResponseDTO(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"), 
				new ObtenerPostResponseDTO(1, 2, "qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla"), 
				new ObtenerPostResponseDTO(1, 3, "ea molestias quasi exercitationem repellat qui ipsa sit aut", "et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut")
				);

		when(managerService.obtenerListadoPost(PageRequest.of(0, 3))).thenReturn(listPostDTO);
		mockMvc.perform(get("/manager")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void obtenerPost() throws Exception {
		ObtenerPostResponseDTO postDTO = new ObtenerPostResponseDTO(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"); 

		when(managerService.obtenerPost(1)).thenReturn(postDTO);
		mockMvc.perform(get("/manager/1")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void obtenerListadoComentarioPost() throws Exception {
		List<ObtenerCommentarioPostResponseDTO> listCommentPostDTO = List.of(
				new ObtenerCommentarioPostResponseDTO(39, 191, "est perferendis eos dolores maxime rerum qui", "Eugene@mohammed.net", "sit vero aut voluptatem soluta corrupti dolor cum\nnulla ipsa accusamus aut suscipit ut dicta ut nemo\nut et ut sit voluptas modi\nillum suscipit ea debitis aut ullam harum"), 
				new ObtenerCommentarioPostResponseDTO(39, 192, "sunt veritatis quisquam est et porro nesciunt excepturi a", "Janick@marty.me", "dolore velit autem perferendis hic\\ntenetur quo rerum\\nimpedit error sit eaque ut\\nad in expedita et nesciunt sit aspernatur repudiandae"), 
				new ObtenerCommentarioPostResponseDTO(39, 193, "quia velit nostrum eligendi voluptates", "Alena@deron.name", "laudantium consequatur sed adipisci a\\nodit quia necessitatibus qui\\nnumquam expedita est accusantium nostrum\\noccaecati perspiciatis molestiae nostrum atque"),
				new ObtenerCommentarioPostResponseDTO(39, 194, "non ut sunt ut eius autem ipsa eos sapiente", "Alphonso_Rosenbaum@valentin.co.uk", "aut distinctio iusto autem sit libero deleniti\\nest soluta non perferendis illo\\neveniet corrupti est sint quae\\nsed sunt voluptatem"), 
				new ObtenerCommentarioPostResponseDTO(39, 195, "tempore vel accusantium qui quidem esse ut aut", "Frank@rosalind.name", "culpa voluptas quidem eos quis excepturi\\nquasi corporis provident enim\\nprovident velit ex occaecati deleniti\\nid aspernatur fugiat eligendi")
				);

		when(managerService.obtenerListadoComentariosPost(39)).thenReturn(listCommentPostDTO);
		mockMvc.perform(get("/manager/comentarios/39")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void obtenerListadoPostPorTitulo() throws Exception {
		List<ObtenerPostResponseDTO> listCommentPostPorTituloDTO = List.of(
				new ObtenerPostResponseDTO(5, 43, "eligendi iste nostrum consequuntur adipisci praesentium sit beatae perferendis", "similique fugit est\nillum et dolorum harum et voluptate eaque quidem\nexercitationem quos nam commodi possimus cum odio nihil nulla\ndolorum exercitationem magnam ex et a et distinctio debitis"), 
				new ObtenerPostResponseDTO(6, 52, "qui enim et consequuntur quia animi quis voluptate quibusdam", "iusto est quibusdam fuga quas quaerat molestias\na enim ut sit accusamus enim\ntemporibus iusto accusantium provident architecto\nsoluta esse reprehenderit qui laborum"), 
				new ObtenerPostResponseDTO(8, 73, "consequuntur deleniti eos quia temporibus ab aliquid at", "voluptatem cumque tenetur consequatur expedita ipsum nemo quia explicabo\naut eum minima consequatur\ntempore cumque quae est et\net in consequuntur voluptatem voluptates aut")
				);

		when(managerService.obtenerListadoPostPorTitulo("consequuntur")).thenReturn(listCommentPostPorTituloDTO);
		mockMvc.perform(get("/manager/titulo/consequuntur")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void guardarPost() throws Exception {
		ObtenerPostResponseDTO obtenerPostResponseDTO = new ObtenerPostResponseDTO(3, 24, "autem hic labore sunt dolores incidunt", "enim et ex nulla\\nomnis voluptas quia qui\\nvoluptatem consequatur numquam aliquam sunt\\ntotam recusandae id dignissimos aut sed asperiores deserunt");
		
		when(managerService.guardarPost(24)).thenReturn(obtenerPostResponseDTO);
		mockMvc.perform(post("/manager/24")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}