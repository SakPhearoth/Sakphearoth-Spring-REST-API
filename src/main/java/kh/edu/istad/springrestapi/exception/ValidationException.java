package kh.edu.istad.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e){

//      detailed response
        List<Map<String,String>> details = new ArrayList<>();
        for(FieldError fieldError : e.getFieldErrors()){

            Map<String,String> error = new HashMap<>();
            error.put("name", fieldError.getField());
            error.put("message", fieldError.getDefaultMessage());
            details.add(error);
        }

        ErrorResponse<List<Map<String,String>>> errorResponse = ErrorResponse.<List<Map<String,String>>>builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .message("Validation failed")
                .details(details)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
