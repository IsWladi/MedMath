package com.iswladi.apimedmath.apimedmath.exception;

import org.springframework.http.HttpStatus;

public class RequestException extends RuntimeException {
    private HttpStatus status;

    public RequestException(HttpStatus status,String message) {
        super(message);
        this.status = status;
    }

	public HttpStatus getStatus() {
		return status;
	}

}
