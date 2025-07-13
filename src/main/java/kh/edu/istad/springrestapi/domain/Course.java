package kh.edu.istad.springrestapi.domain;


import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private UUID id;
    private String code;
    private String title;
    private String description;
    private Double price;
    private Boolean status;
}
