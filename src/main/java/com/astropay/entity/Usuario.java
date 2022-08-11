package com.astropay.entity;

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
public class Usuario {

	private String username;
	
	private String password;
}
