package com.astropay.dto;

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
public class UsuarioDTO {

	@Schema(description = "Nombre de usuario")
	private String user;
	
	@Schema(description = "Token del usuario")
	private String token;
}
