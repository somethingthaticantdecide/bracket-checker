package org.sbt.bracketchecker.exception;

import org.sbt.bracketchecker.dto.ApiError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@ControllerAdvice
public class CheckerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiError> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse("Invalid request");
        return new ResponseEntity<>(
                new ApiError(message, OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> illegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)),
                HttpStatus.BAD_REQUEST);
    }
}
