package Main.PontoEletronico.Infra.Exceptions;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("errors", ex.getBindingResult().getAllErrors().stream().map(error -> {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("field", ((FieldError) error).getField());
            errorDetails.put("message", error.getDefaultMessage());
            return errorDetails;
        }).toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @Getter
    @Setter
    public static class ErrorResponse{
        private int status;
        private String message;

        public ErrorResponse(int status, String message){
            this.status = status;
            this.message = message;
        }
    }
}
