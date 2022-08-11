package com.astropay.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.astropay.dto.GuardarPostRequestDTO;
import com.astropay.dto.ObtenerPostCommentResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;

/**
 * Interface de Manager
 * @author buttazzo
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public interface ManagerService {
	
	/*
	 * Retorna el listado de post paginado
	 * @param Pageable
	 * @return List<PostResponseDTO>
	 */
	public List<ObtenerPostResponseDTO> obtenerListadoPost(Pageable pageable);
	
	/*
	 * Retorna el listado de comentarios de un post paginado
	 * @param idPost
	 * @param Pageable
	 * @return List<PostCommentResponseDTO>
	 */
	public List<ObtenerPostCommentResponseDTO> obtenerListadoComentariosPost(Integer idPost, Pageable pageable);
		
	/*
	 * Retorna el listado de post con el titulo ingresado
	 * @param titulo
	 * @return List<PostResponseDTO>
	 */
	public List<ObtenerPostResponseDTO> obtenerListadoPostPorTitulo(String titulo);
		
	/*
	 * Guarda un nuevo post en la BD
	 * @param guardarPostRequestDTO
	 * @return PostResponseDTO
	 */
	public ObtenerPostResponseDTO guardarPost(GuardarPostRequestDTO guardarPostRequestDTO);
}