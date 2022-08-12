package com.astropay.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.astropay.dto.ObtenerCommentarioPostResponseDTO;
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
	 * Retorna el detalle de un post
	 * @param idPost
	 * @return List<ObtenerPostResponseDTO>
	 */
	public ObtenerPostResponseDTO obtenerPost(Integer idPost);
	
	/*
	 * Retorna el listado de comentarios de un post
	 * @param idPost
	 * @return List<PostCommentResponseDTO>
	 */
	public List<ObtenerCommentarioPostResponseDTO> obtenerListadoComentariosPost(Integer idPost);
		
	/*
	 * Retorna el listado de post con el titulo ingresado
	 * @param titulo
	 * @return List<PostResponseDTO>
	 */
	public List<ObtenerPostResponseDTO> obtenerListadoPostPorTitulo(String titulo);
		
	/*
	 * Guarda en la BD un post con sus comentarios desde la API de Blog
	 * @param idPost
	 * @return PostResponseDTO
	 */
	public ObtenerPostResponseDTO guardarPost(Integer idPost);
}