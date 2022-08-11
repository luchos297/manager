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
import com.astropay.dto.ObtenerPostCommentResponseDTO;

@WebMvcTest(controllers = ManagerController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class ObtenerListadoComentarioTest {

	@MockBean
	private ManagerController managerController;

	@Autowired
	private MockMvc mockMvc;

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
}