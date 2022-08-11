package com.astropay.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
public class GuardarPostRequestDTO {

	@Schema(description = "ID del usuario", example = "1")
	@NotNull(message = "El valor del ID del usuario debe ser válido")
	@Positive
	private Integer userId;
	
	@Schema(description = "Título del post", example = "sunt aut facere repellat")
	@NotNull(message = "El valor del título debe ser válido")
	private String title;
	
	@Schema(description = "Cuerpo del post", example = "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehende")
	@NotNull(message = "El valor del cuerpo debe ser válido")
	private String body;
}
