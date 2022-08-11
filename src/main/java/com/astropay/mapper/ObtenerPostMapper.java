package com.astropay.mapper;

import java.util.List;

import com.astropay.dto.ObtenerPostResponseDTO;
import com.astropay.entity.PostEntity;

/**
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public interface ObtenerPostMapper extends AbstractMapper<ObtenerPostResponseDTO, PostEntity> {

	public PostEntity toEntity(ObtenerPostResponseDTO post);
	
	public ObtenerPostResponseDTO toDto(PostEntity post);
	
	public List<ObtenerPostResponseDTO> listToDto(List<PostEntity> list);
	
	public List<PostEntity> listToEntity(List<ObtenerPostResponseDTO> list);
}
