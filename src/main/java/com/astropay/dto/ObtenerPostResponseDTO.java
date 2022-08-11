package com.astropay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buttazzo
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObtenerPostResponseDTO {

	@Schema(description = "ID del usuario")
	@JsonProperty("userId")
	private Integer userId;
	
	@Schema(description = "ID del post")
	@JsonProperty("id")
	private Integer id;
	
	@Schema(description = "Título del post")
	@JsonProperty("title")
	private String title;
	
	@Schema(description = "Cuerpo del post")
	@JsonProperty("body")
	private String body;
}
