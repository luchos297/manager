package com.astropay.service;

import static com.astropay.constant.Constant.ERR_MANAGER_POST_ID_CANNOT_BE_NULL;
import static com.astropay.constant.Constant.ERR_MANAGER_THERE_IS_NO_COMMENT_POST;
import static com.astropay.constant.Constant.ERR_MANAGER_THERE_IS_NO_LIST_POST;
import static com.astropay.constant.Constant.ERR_MANAGER_THERE_IS_NO_POST;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.astropay.dto.ObtenerCommentarioPostResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;
import com.astropay.entity.ComentarioPostEntity;
import com.astropay.entity.PostEntity;
import com.astropay.exceptions.ManagerServiceException;
import com.astropay.feign.BlogClient;
import com.astropay.repository.ComentarioPostRepository;
import com.astropay.repository.PostRepository;

/**
 * Servicio de Manager
 * @author buttazzo
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Service
public class ManagerServiceImpl implements ManagerService {
	
	private static Logger logger = Logger.getLogger(ManagerServiceImpl.class.getName());

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ComentarioPostRepository comentarioPostRepository;
	
	@Autowired
	private BlogClient blogClient;

	public List<ObtenerPostResponseDTO> obtenerListadoPost(Pageable pageable) {
		logger.log(Level.INFO, "SERVICE -> 'ManagerService.obtenerListadoPost()'");

		ResponseEntity<List<ObtenerPostResponseDTO>> listPostResponseAPI = blogClient.obtenerListadoPost();
		
		if(!listPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_LIST_POST);
		}
		else {
			List<ObtenerPostResponseDTO> list = listPostResponseAPI.getBody();
			int start = pageable.getPageNumber() * pageable.getPageSize();
		    int end = Math.min(start + pageable.getPageSize(), list.size());

		    List<ObtenerPostResponseDTO> subList = list.subList(start, end);

		    return new PageImpl<ObtenerPostResponseDTO>(subList, pageable, subList.size()).getContent();
		}
	}
	
	public ObtenerPostResponseDTO obtenerPost(Integer idPost) {
		logger.log(Level.INFO, "SERVICE -> 'ManagerService.obtenerPost()'");

		ResponseEntity<ObtenerPostResponseDTO> postResponseAPI = blogClient.obtenerPost(idPost);
		
		if(!postResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(postResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(postResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_POST);
		}
		
		return postResponseAPI.getBody();
	}
	
	public List<ObtenerCommentarioPostResponseDTO> obtenerListadoComentariosPost(Integer idPost) {
		logger.log(Level.INFO, "SERVICE -> 'ManagerService.obtenerListadoComentariosPost()'");

		ResponseEntity<List<ObtenerCommentarioPostResponseDTO>> listComentariosPostResponseAPI = blogClient.obtenerListadoComentarioPost(idPost);
		
		if(!listComentariosPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listComentariosPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listComentariosPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_COMMENT_POST);
		}
		if(listComentariosPostResponseAPI.getBody().isEmpty()) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_COMMENT_POST);
		}

		return listComentariosPostResponseAPI.getBody();
	}
	
	public List<ObtenerPostResponseDTO> obtenerListadoPostPorTitulo(String titulo) {
		logger.log(Level.INFO, "SERVICE -> 'ManagerService.obtenerListadoPostPorTitulo()'");

		ResponseEntity<List<ObtenerPostResponseDTO>> listComentariosPostResponseAPI = blogClient.obtenerListadoPost();
		
		if(!listComentariosPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listComentariosPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listComentariosPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_COMMENT_POST);
		}
		
		List<ObtenerPostResponseDTO> list = listComentariosPostResponseAPI.getBody();
			
		return list.stream().filter(post -> post.getTitle().contains(titulo)).collect(Collectors.toList());
	}
	
	public ObtenerPostResponseDTO guardarPost(Integer idPost) {
		logger.log(Level.INFO, "SERVICE -> 'ManagerService.guardarPost()'");

		if(Objects.isNull(idPost)) {
			throw new ManagerServiceException(ERR_MANAGER_POST_ID_CANNOT_BE_NULL);
		}
		
		ResponseEntity<ObtenerPostResponseDTO> postResponseAPI = blogClient.obtenerPost(idPost);
		
		if(!postResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(postResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(postResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_POST);
		}
		
		ResponseEntity<List<ObtenerCommentarioPostResponseDTO>> listComentariosPostResponseAPI = blogClient.obtenerListadoComentarioPost(idPost);
		
		if(!listComentariosPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listComentariosPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listComentariosPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_COMMENT_POST);
		}
		
		PostEntity post = new PostEntity(postResponseAPI.getBody().getCodigo(), postResponseAPI.getBody().getUserId(), postResponseAPI.getBody().getTitle(), postResponseAPI.getBody().getBody());
		
		List<ComentarioPostEntity> comentarios = new ArrayList<>();
		for ( ObtenerCommentarioPostResponseDTO comentario : listComentariosPostResponseAPI.getBody()) {
			comentarios.add(new ComentarioPostEntity(comentario.getCodigo(), comentario.getName(), comentario.getEmail(), comentario.getBody(), post));
		}
		
		PostEntity newEntity = postRepository.save(post);
		comentarioPostRepository.saveAll(comentarios);
		
		return modelMapper.map(newEntity, ObtenerPostResponseDTO.class);
	}
}
