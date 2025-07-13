package kh.edu.istad.springrestapi.repository;

import kh.edu.istad.springrestapi.domain.Course;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Annotation-based configuration
@Repository
@Getter
public class CourseRepository {

    List<Course> courses;

    public CourseRepository() {

        courses = new ArrayList<>();

        //use Builder annotation
        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("A111")
                .title("Web Design")
                .description("This course teaches you how to design web pages")
                .price(150.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("B234")
                .title("Java Programming")
                .description("Write once run everywhere")
                .price(200.00)
                .status(false)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("C345")
                .title("UX/UI Design")
                .description("UX/UI Design Description")
                .price(130.00)
                .status(true)
                .build());

        courses.add(Course.builder()
                .id(UUID.randomUUID())
                .code("D456")
                .title("Data Analytics")
                .description("Data Analytics Description")
                .price(120.00)
                .status(false)
                .build());
    }
}
