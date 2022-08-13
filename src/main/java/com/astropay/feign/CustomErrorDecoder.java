package com.astropay.feign;

import static com.astropay.constant.Constant.ERR_FEIGN_400;
import static com.astropay.constant.Constant.ERR_FEIGN_404;
import static com.astropay.constant.Constant.ERR_FEIGN_500;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Manejador de Excepciones de Feign
 * @author luchos297
 * @version 1.0.0
 * @since 09 aug. 2022
 */
public class CustomErrorDecoder implements ErrorDecoder {
    
	@Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
        	case 400:
        		return new HttpClientErrorException(HttpStatus.BAD_REQUEST, ERR_FEIGN_400);
        	case 404:
            	return new HttpClientErrorException(HttpStatus.NOT_FOUND, ERR_FEIGN_404);
            default:
            	return new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, ERR_FEIGN_500);
        }
    }
}