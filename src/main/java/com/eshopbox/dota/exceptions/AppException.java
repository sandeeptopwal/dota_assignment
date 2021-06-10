package com.eshopbox.dota.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;
}
