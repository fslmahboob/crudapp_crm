package exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class RestExceptionHandler {
	
	/* Have to use these next lines of code for every exception you create */
	
	// The exception we want to handle
	@ExceptionHandler(NotFoundException.class)
	// The HTTP status you want associated - eg. 404 in this case
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorResponse handle(NotFoundException e) {
		return new ApiErrorResponse(e.getMessage());
	}
	
	// Another example - conflict exception
	// Posting something twice will cause this error to be thrown
	@ExceptionHandler(ConflictException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ApiErrorResponse handle(ConflictException e) {
		return new ApiErrorResponse(e.getMessage());
	}
	
//	@ExceptionHandler(ValidationException.class)
//	@ResponseStatus(HttpStatus.CONFLICT)
//	public ApiErrorResponse handle(ValidationException e) {
//		return new ApiErrorResponse(e.getMessage());
//	}
}

