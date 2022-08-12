package com.astropay.feign;

import static com.astropay.constant.Constant.API_OPERATION_NAME_OLCP;
import static com.astropay.constant.Constant.API_OPERATION_NAME_OLP;
import static com.astropay.constant.Constant.API_OPERATION_NAME_OP;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.astropay.dto.ObtenerCommentarioPostResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Interface de la API de Blog
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@FeignClient(name = "BlogClient", url = "https://jsonplaceholder.typicode.com/")
public interface BlogClient {
	
	@GetMapping(path = "posts")
	@Operation(summary = API_OPERATION_NAME_OLP)
	public ResponseEntity<List<ObtenerPostResponseDTO>> obtenerListadoPost();

	@GetMapping(path = "posts/{idPost}")
	@Operation(summary = API_OPERATION_NAME_OP)
	public ResponseEntity<ObtenerPostResponseDTO> obtenerPost(@PathVariable("idPost") Integer idPost);
	
	@GetMapping(path = "posts/{idPost}/comments")
	@Operation(summary = API_OPERATION_NAME_OLCP)
	public ResponseEntity<List<ObtenerCommentarioPostResponseDTO>> obtenerListadoComentarioPost(@PathVariable("idPost") Integer idPost);
}
