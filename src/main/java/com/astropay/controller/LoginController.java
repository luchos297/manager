package com.astropay.controller;

import static com.astropay.constant.Constant.API_LOGIN_TAG;
import static com.astropay.constant.Constant.API_OPERATION_NOTES_LU;
import static com.astropay.constant.Constant.API_OPERATION_VALUE_LU;
import static com.astropay.constant.Constant.API_RESPONSE_200_LU;
import static com.astropay.constant.Constant.API_RESPONSE_404;
import static com.astropay.constant.Constant.APPLICATION_JSON;
import static com.astropay.constant.Constant.AUTHORIZATION_TYPE;
import static com.astropay.constant.Constant.RESPONSE_CODE_200;
import static com.astropay.constant.Constant.RESPONSE_CODE_404;
import static com.astropay.constant.UrlPathConstant.PATH_LOGIN;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astropay.dto.UsuarioDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador de Manager
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
@RestController
@Validated
@RequestMapping(path = PATH_LOGIN, produces = APPLICATION_JSON)
public class LoginController {

	@PostMapping
	@Operation(summary = API_OPERATION_VALUE_LU, description = API_OPERATION_NOTES_LU, tags = {API_LOGIN_TAG}, security = { @SecurityRequirement(name = AUTHORIZATION_TYPE) })
	@ApiResponses(value = {
		@ApiResponse(description = API_RESPONSE_200_LU, responseCode = RESPONSE_CODE_200, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_404, responseCode = RESPONSE_CODE_404, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),	
	})
	public UsuarioDTO login(@RequestParam("user") String user, @RequestParam("pass") String pass) {
		String token = getJWTToken(user);
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setUser(user);
		usuario.setToken(token);		
		
		return usuario;
	}

	@SuppressWarnings("deprecation")
	private String getJWTToken(String user) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(user)
				.claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}