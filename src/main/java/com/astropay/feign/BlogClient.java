package com.astropay.feign;

import static com.astropay.constant.Constant.API_OPERATION_NAME_OLCP;
import static com.astropay.constant.Constant.API_OPERATION_NAME_OLP;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.astropay.dto.ObtenerPostCommentResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @author buttazzo
 * @version 1.0.0
 * @since 14 jun. 2022
 */
@FeignClient(name = "BlogClient", url = "https://jsonplaceholder.typicode.com/posts")
public interface BlogClient {
	
	@GetMapping(path = "manager")
	@Operation(summary = API_OPERATION_NAME_OLP)
	public ResponseEntity<List<ObtenerPostResponseDTO>> obtenerListadoPost();

	@GetMapping(path = "manager/{idPost}/comments")
	@Operation(summary = API_OPERATION_NAME_OLCP)
	public ResponseEntity<List<ObtenerPostCommentResponseDTO>> obtenerListadoComentarioPost(@PathVariable("idPost") String idPost);
}
