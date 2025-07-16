package kh.edu.istad.springrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CourseRequest(
        @NotBlank (message = "Course code is required!")
        String code,

        @NotBlank (message = "Course title is required!")
        String title,

        @NotBlank (message = "Course description is required!")
        String description,

        @NotBlank (message = "Course price is required!")
        Double price
) {
}

//domain -> dto -> service
