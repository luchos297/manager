package com.astropay.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.astropay.dto.GuardarPostRequestDTO;
import com.astropay.entity.PostEntity;

/**
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Mapper(componentModel = "spring", uses = {})
public interface GuardarPostRequestMapper extends AbstractMapper<GuardarPostRequestDTO, PostEntity> {

	public PostEntity toEntity(GuardarPostRequestDTO post);
	
	public GuardarPostRequestDTO toDto(PostEntity post);
	
	public List<GuardarPostRequestDTO> listToDto(List<PostEntity> list);
	
	public List<PostEntity> listToEntity(List<GuardarPostRequestDTO> list);
}
