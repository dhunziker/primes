package primes.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Used to customise Spring Boot's exception handling. Any of the mappings in here are applied to
 * all classes annotated with @RestController.
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	void handleIllegalArgumentException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
