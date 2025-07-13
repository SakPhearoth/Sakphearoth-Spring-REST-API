package kh.edu.istad.springrestapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ServiceException {

    /*
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<?,?>> handleServiceException(ResponseStatusException e){

        Map<String, Object> error = new HashMap<>();
        error.put("status", e.getStatusCode().value());
        error.put("message", e.getReason());
        error.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(e.getStatusCode()).body(error);
    }
    */



//    ErrorResponse
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse<?>> handleServiceException(ResponseStatusException e){
        ErrorResponse<Object> errorResponse = new ErrorResponse<>(
                e.getReason(),
                e.getStatusCode().value(),
                LocalDateTime.now(),
                null
        );
        return ResponseEntity
                .status(e.getStatusCode())
                .body(errorResponse);
    }

}
