package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dto.ErrorDto;
import com.taisiia.musicApp.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
@Slf4j
public class AdviceController {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        log.error("Not found entity", entityNotFoundException);


        return new ErrorDto(entityNotFoundException.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFoundException(NotFoundException notFoundException) {
        log.error("Not found entity", notFoundException);


        return new ErrorDto(notFoundException.getMessage());
    }

}
