package com.astropay.constant;

/**
 * @apiNote Constante de configuración, controladores y errores
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public class Constant {
	
	private Constant() {}
	
	// Auth
	public static final String CREDENCIALES_INVALIDAS = "Credenciales inválidas";
	public static final String MSG_ERROR = "{\"error\": \"Credenciales inválidas\"} ";
	public static final String TYPE_JSON = "application/json; charset=utf-8";
	public static final String APPLICATION_JSON = "application/json";
	public static final String AUTHORIZATION = "Authorization";
	public static final String AUTHORIZATION_TYPE = "bearer-key";
	public static final String BEARER = "Bearer";
	public static final String HEADER = "header";
	public static final String USUARIO = "USUARIO";
	public static final String USER = "USER";
	public static final String OPTIONS = "OPTIONS";
	public static final String TOKEN = "token";
	public static final String URL_LOWER = "url";
	public static final String BASIC = "Basic ";
	public static final String DO_FILTER = "doFilter";
	public static final String OBTENER_USER_METHOD = "getUsuario";
	public static final String OBTENER_ENCABEZADO = "Obtener encabezado - HEADER: ";
	public static final String OBTENER_USER = "Obtener usuario - USER: ";
	public static final String USUARIO_ESTADO_ACTIVO = "ACTIVO";
	public static final String CONTENT_LENGTH = "Content-Length";
	public static final String DEFAULT_COLOR = "blanco";
	
	// Configuration
	public static final String API_NAME = "API Manager";
	public static final String API_DESCRIPTION = "Basic CRUD of posts";
	public static final String API_MANAGER_TAG_DESCRIPCION = "Listado de endpoints de administrador";

	// Controller
	public static final String CONTROLLER_LABEL_DESCRIPCION = "<h3> Descripción: </h3>";
	public static final String CONTROLLER_LABEL_REQUISITOS = "<h3> Requisitos: </h3>";
	public static final String RESPONSE_CODE_200 = "200";
	public static final String RESPONSE_CODE_400 = "400";
	public static final String RESPONSE_CODE_404 = "404";
	public static final String API_RESPONSE_400 = "Solicitud incorrecta";
	public static final String API_RESPONSE_404 = "Recurso no encontrado";

	// Controller de Manager
	public static final String API_MANAGER_CONTROLLER = "Controlador de Manager";
	public static final String API_MANAGER_TAG = "manager";
	public static final String API_MANAGER_FEIGN_TAG = "post";
	
	public static final String API_OPERATION_VALUE_OLP = "Endpoint para obtener el listado de posts";
	public static final String API_OPERATION_NOTES_OLP = CONTROLLER_LABEL_DESCRIPCION + "<p> Este endpoint es utilizado para obtener el listado de posts paginados desde la API de Blog </p>";
	public static final String API_RESPONSE_200_OLP = "Listado de post obtenido con éxito";
	
	public static final String API_OPERATION_VALUE_OLCP = "Endpoint para obtener el listado de comentarios de un post";
	public static final String API_OPERATION_NOTES_OLCP = CONTROLLER_LABEL_DESCRIPCION + "<p> Este endpoint es utilizado para obtener el listado de comentarios de un post desde la API de Blog </p>"
			+ CONTROLLER_LABEL_REQUISITOS
			+ "<p> El idPost debe ser válido </p>";
	public static final String API_RESPONSE_200_OLCP = "Listado de comentarios de un post obtenido con éxito";
	
	public static final String API_OPERATION_VALUE_OLPT = "Endpoint para obtener el listado de posts por titulo";
	public static final String API_OPERATION_NOTES_OLPT = CONTROLLER_LABEL_DESCRIPCION + "<p> Este endpoint es utilizado para obtener el listado de posts por titulo desde la API de Blog </p>"
			+ CONTROLLER_LABEL_REQUISITOS
			+ "<p> El título debe ser válido </p>";
	public static final String API_RESPONSE_200_OLPT = "Listado de posts obtenido con éxito";
	
	public static final String API_OPERATION_VALUE_GP = "Endpoint para guardar el post";
	public static final String API_OPERATION_NOTES_GP = CONTROLLER_LABEL_DESCRIPCION + "<p> Este endpoint es utilizado para guardar el post en la tabla '<b>POST</b>' del esquema '<b>MANAGER</b>' </p>"
			+ CONTROLLER_LABEL_REQUISITOS
			+ "<p> El ID de usuario debe ser válido </p>"
			+ "<p> El título debe ser válido </p>"
			+ "<p> El cuerpo debe ser válido </p>";
	public static final String API_RESPONSE_200_GP = "Post guardado con éxito";
	
	// Interface Feign BlogClient
	public static final String FEIGN_POSSIBLES_REQUESTS = "<h3> Solicitud: </h3> <p> El token y la URL deben ser válidos </p>";
	public static final String API_OPERATION_NAME_OLP = "<h3> Descripción: </h3> <p> Este endpoint es utilizado para obtener el listado de posts en la API de Blog </p>"
		+ FEIGN_POSSIBLES_REQUESTS + "<h3> Response: </h3> <p> Code 200: OK (PostResponseAPI) </p> <p> Code 404: NOT FOUND </p>";

	public static final String API_OPERATION_NAME_OLCP = "<h3> Descripción: </h3> <p> Este endpoint es utilizado para obtener el listado de comentarios de un post en la API de Blog </p>"
		+ FEIGN_POSSIBLES_REQUESTS + "<h3> Response: </h3> <p> Code 200: OK (PostCommentResponseAPI) </p> <p> Code 404: NOT FOUND </p>";

	// Errores
	public static final String ERR_MANAGER_THERE_IS_NO_POST = "No hay posts para listar";
	public static final String ERR_MANAGER_THERE_IS_NO_COMMENT_POST = "No hay comentarios del post para listar";
	public static final String ERR_MANAGER_POST_CANNOT_BE_NULL = "El post no puede ser nulo";
}