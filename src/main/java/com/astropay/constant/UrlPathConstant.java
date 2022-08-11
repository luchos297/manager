package com.astropay.constant;

/**
 * @apiNote Constante para las URLs 
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public class UrlPathConstant {
	
	private UrlPathConstant() {}

	public static final String PATH_SLASH = "/";
	public static final String PATH_FILTER_CHAIN = "/*";
	
	// Parametros
	public static final String PATH_VARIABLE_ID_POST = PATH_SLASH + "{idPost}";
	
	// Manager
	public static final String PATH_MANAGER = PATH_SLASH + "manager";
	public static final String PATH_MANAGER_FILTER =  PATH_MANAGER + PATH_FILTER_CHAIN;
}
