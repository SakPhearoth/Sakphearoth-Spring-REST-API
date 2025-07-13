package kh.edu.istad.springrestapi.exception;

import java.time.LocalDateTime;

public record ErrorResponse<T>(
        String message,
        Integer statusCode,
        LocalDateTime timestamp,
        T details
) {
}
