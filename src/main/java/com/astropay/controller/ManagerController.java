package com.astropay.controller;

import static com.astropay.constant.Constant.API_MANAGER_TAG;
import static com.astropay.constant.Constant.API_OPERATION_NOTES_GP;
import static com.astropay.constant.Constant.API_OPERATION_NOTES_OLCP;
import static com.astropay.constant.Constant.API_OPERATION_NOTES_OLP;
import static com.astropay.constant.Constant.API_OPERATION_NOTES_OLPT;
import static com.astropay.constant.Constant.API_OPERATION_VALUE_GP;
import static com.astropay.constant.Constant.API_OPERATION_VALUE_OLCP;
import static com.astropay.constant.Constant.API_OPERATION_VALUE_OLP;
import static com.astropay.constant.Constant.API_OPERATION_VALUE_OLPT;
import static com.astropay.constant.Constant.API_RESPONSE_200_GP;
import static com.astropay.constant.Constant.API_RESPONSE_200_OLCP;
import static com.astropay.constant.Constant.API_RESPONSE_200_OLP;
import static com.astropay.constant.Constant.API_RESPONSE_200_OLPT;
import static com.astropay.constant.Constant.API_RESPONSE_400;
import static com.astropay.constant.Constant.API_RESPONSE_404;
import static com.astropay.constant.Constant.APPLICATION_JSON;
import static com.astropay.constant.Constant.AUTHORIZATION_TYPE;
import static com.astropay.constant.Constant.RESPONSE_CODE_200;
import static com.astropay.constant.Constant.RESPONSE_CODE_400;
import static com.astropay.constant.Constant.RESPONSE_CODE_404;
import static com.astropay.constant.UrlPathConstant.PATH_MANAGER;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astropay.dto.GuardarPostRequestDTO;
import com.astropay.service.ManagerService;

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
@RequestMapping(path = PATH_MANAGER, produces = APPLICATION_JSON)
public class ManagerController {
    
	private static Logger logger = Logger.getLogger(ManagerController.class.getName());
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping
	@Operation(summary = API_OPERATION_VALUE_OLP, description = API_OPERATION_NOTES_OLP, tags = {API_MANAGER_TAG}, security = { @SecurityRequirement(name = AUTHORIZATION_TYPE) })
	@ApiResponses(value = {
		@ApiResponse(description = API_RESPONSE_200_OLP, responseCode = RESPONSE_CODE_200, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_400, responseCode = RESPONSE_CODE_400, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_404, responseCode = RESPONSE_CODE_404, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),	
	})
	public ResponseEntity<?> obtenerListadoPosts(@PathVariable("page") Integer page, @PathVariable("number") Integer number) {
		logger.log(Level.INFO, "CONTROLLER -> 'ManagerController.obtenerListadoPosts()'");
		
		return ResponseEntity.ok(managerService.obtenerListadoPost(page, number));
	}
	
	@GetMapping
	@Operation(summary = API_OPERATION_VALUE_OLCP, description = API_OPERATION_NOTES_OLCP, tags = {API_MANAGER_TAG}, security = { @SecurityRequirement(name = AUTHORIZATION_TYPE) })
	@ApiResponses(value = {
		@ApiResponse(description = API_RESPONSE_200_OLCP, responseCode = RESPONSE_CODE_200, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_400, responseCode = RESPONSE_CODE_400, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_404, responseCode = RESPONSE_CODE_404, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),	
	})
	public ResponseEntity<?> obtenerListadoComentarioPost(String idPost, @PathVariable("page") Integer page, @PathVariable("number") Integer number) {
		logger.log(Level.INFO, "WEB -> 'ManagerController.obtenerListadoComentarioPost()'");
		
		return ResponseEntity.ok(managerService.obtenerListadoComentariosPost(idPost, page, number));
	}
	
	@GetMapping
	@Operation(summary = API_OPERATION_VALUE_OLPT, description = API_OPERATION_NOTES_OLPT, tags = {API_MANAGER_TAG}, security = { @SecurityRequirement(name = AUTHORIZATION_TYPE) })
	@ApiResponses(value = {
		@ApiResponse(description = API_RESPONSE_200_OLPT, responseCode = RESPONSE_CODE_200, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_400, responseCode = RESPONSE_CODE_400, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_404, responseCode = RESPONSE_CODE_404, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),	
	})
	public ResponseEntity<?> obtenerListadoPostPorTitulo(String titulo) {
		logger.log(Level.INFO, "WEB -> 'ManagerController.obtenerListadoPostPorTitulo()'");
		
		return ResponseEntity.ok(managerService.obtenerListadoPostPorTitulo(titulo));
	}
	
	@PostMapping
	@Operation(summary = API_OPERATION_VALUE_GP, description = API_OPERATION_NOTES_GP, tags = {API_MANAGER_TAG}, security = { @SecurityRequirement(name = AUTHORIZATION_TYPE) })
	@ApiResponses(value = {
		@ApiResponse(description = API_RESPONSE_200_GP, responseCode = RESPONSE_CODE_200, content = {	@Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_400, responseCode = RESPONSE_CODE_400, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),
		@ApiResponse(description = API_RESPONSE_404, responseCode = RESPONSE_CODE_404, content = { @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ResponseEntity.class))}),	
	})
	public ResponseEntity<?> guardarPost(@RequestBody @Valid GuardarPostRequestDTO guardarPostRequestDTO) {
		logger.log(Level.INFO, "WEB -> 'AsistenciaController.crearAsistencia()'");
		
		return ResponseEntity.ok(managerService.guardarPost(guardarPostRequestDTO));
	}
}
