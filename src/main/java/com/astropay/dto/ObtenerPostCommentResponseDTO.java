package com.astropay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ObtenerPostCommentResponseDTO {
	
	@Schema(description = "ID del post")
	@JsonProperty("postId")
	private Integer postId;

	@Schema(description = "ID del comentario")
	@JsonProperty("id")
	private Integer id;

	@Schema(description = "Nombre del autor")
	@JsonProperty("name")
	private String name;

	@Schema(description = "Email del autor")
	@JsonProperty("email")
	private String email;
	
	@Schema(description = "Cuerpo del post")
	@JsonProperty("body")
	private String body;	
}
