package com.astropay.service;

import static com.astropay.constant.Constant.ERR_MANAGER_POST_CANNOT_BE_NULL;
import static com.astropay.constant.Constant.ERR_MANAGER_THERE_IS_NO_COMMENT_POST;
import static com.astropay.constant.Constant.ERR_MANAGER_THERE_IS_NO_POST;

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

import com.astropay.dto.GuardarPostRequestDTO;
import com.astropay.dto.ObtenerPostCommentResponseDTO;
import com.astropay.dto.ObtenerPostResponseDTO;
import com.astropay.entity.PostEntity;
import com.astropay.exceptions.ManagerServiceException;
import com.astropay.feign.BlogClient;
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
	private BlogClient blogClient;

	public List<ObtenerPostResponseDTO> obtenerListadoPost(Pageable pageable) {
		logger.log(Level.INFO, "SERVICE -> 'PostService.obtenerListadoPost()'");

		ResponseEntity<List<ObtenerPostResponseDTO>> listPostResponseAPI = blogClient.obtenerListadoPost();
		
		if(!listPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_POST);
		}
		else {
			int start = pageable.getPageNumber() * pageable.getPageSize();
		    int end = Math.min(start + pageable.getPageSize(), listPostResponseAPI.getBody().size());

		    List<ObtenerPostResponseDTO> subList = listPostResponseAPI.getBody().subList(start, end);

		    return new PageImpl<ObtenerPostResponseDTO>(subList, pageable, subList.size()).getContent();
		}
	}
	
	public List<ObtenerPostCommentResponseDTO> obtenerListadoComentariosPost(String idPost, Pageable pageable) {
		logger.log(Level.INFO, "SERVICE -> 'PostService.obtenerListadoComentariosPost()'");

		ResponseEntity<List<ObtenerPostCommentResponseDTO>> listComentariosPostResponseAPI = blogClient.obtenerListadoComentarioPost(idPost);
		
		if(!listComentariosPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listComentariosPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listComentariosPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_COMMENT_POST);
		}
		else {
			int start = pageable.getPageNumber() * pageable.getPageSize();
		    int end = Math.min(start + pageable.getPageSize(), listComentariosPostResponseAPI.getBody().size());

		    List<ObtenerPostCommentResponseDTO> subList = listComentariosPostResponseAPI.getBody().subList(start, end);

		    return new PageImpl<ObtenerPostCommentResponseDTO>(subList, pageable, subList.size()).getContent();
		}
	}
	
	public List<ObtenerPostResponseDTO> obtenerListadoPostPorTitulo(String titulo) {
		logger.log(Level.INFO, "SERVICE -> 'PostService.obtenerListadoPostPorTitulo()'");

		ResponseEntity<List<ObtenerPostResponseDTO>> listComentariosPostResponseAPI = blogClient.obtenerListadoPost();
		
		if(!listComentariosPostResponseAPI.getStatusCode().is2xxSuccessful()) {
			throw new ManagerServiceException(listComentariosPostResponseAPI.getStatusCode().toString());
		}
		
		if(Objects.isNull(listComentariosPostResponseAPI.getBody())) {
			throw new ManagerServiceException(ERR_MANAGER_THERE_IS_NO_COMMENT_POST);
		}

		List<ObtenerPostResponseDTO> listComentariosPostFiltradoResponseAPI = listComentariosPostResponseAPI.getBody().stream().filter(post -> post.getTitle().startsWith(titulo)).collect(Collectors.toList());
	    
		return listComentariosPostFiltradoResponseAPI;
	}
	
	public ObtenerPostResponseDTO guardarPost(GuardarPostRequestDTO guardarPostRequestDTO) {
		logger.log(Level.INFO, "SERVICE -> 'PostService.guardarPost()'");

		if(Objects.isNull(guardarPostRequestDTO)) {
			throw new ManagerServiceException(ERR_MANAGER_POST_CANNOT_BE_NULL);
		}
		
		PostEntity newEntity = postRepository.save(modelMapper.map(guardarPostRequestDTO, PostEntity.class));
		
		return modelMapper.map(newEntity, ObtenerPostResponseDTO.class);
	}
}
