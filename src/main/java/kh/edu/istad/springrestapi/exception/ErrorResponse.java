package kh.edu.istad.springrestapi.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse<T>(
        String message,
        Integer statusCode,
        LocalDateTime timestamp,
        T details
) {
}
