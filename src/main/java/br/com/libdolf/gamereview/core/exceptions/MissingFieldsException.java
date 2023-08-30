package br.com.libdolf.gamereview.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MissingFieldsException extends RuntimeException {
    public MissingFieldsException(String message) {
        super(message);
    }

}
