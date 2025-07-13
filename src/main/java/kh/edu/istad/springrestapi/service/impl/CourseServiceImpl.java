package kh.edu.istad.springrestapi.service.impl;

import kh.edu.istad.springrestapi.domain.Course;
import kh.edu.istad.springrestapi.dto.CourseRequest;
import kh.edu.istad.springrestapi.dto.CourseResponse;
import kh.edu.istad.springrestapi.repository.CourseRepository;
import kh.edu.istad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    //Define dependency
    private final CourseRepository courseRepository;

    //1. Get all courses
//    @Override
//    public List<CourseResponse> getCourses() {
//        return courseRepository.getCourses().stream()
//                .map(this::mapToResponse)
//                .toList();
//    }

    //2. Get courses by status
//    @Override
//    public List<CourseResponse> getCourseByStatus(String status) {
//        return courseRepository.getCourses().stream()
//                .filter(course -> {
//                    if (status == null || status.isEmpty()) return true;
//
//                    return (status.equalsIgnoreCase("true") && course.getStatus()) ||
//                            (status.equalsIgnoreCase("false") && !course.getStatus());
//                })
//                .map(this::mapToResponse)
//                .toList();
//    }

    //3. Get course by title and status (optional)
//    @Override
//    public List<CourseResponse> getCourseByTitle(String status, String title) {
//        return courseRepository.getCourses().stream()
//                .filter(course -> {
//                    boolean matchesStatus = (status == null || status.isEmpty()) ||
//                            (status.equalsIgnoreCase("true") && course.getStatus()) ||
//                            (status.equalsIgnoreCase("false") && !course.getStatus());
//                    boolean matchesTitle = title != null &&
//                            course.getTitle().toLowerCase().contains(title.toLowerCase());
//                    return matchesStatus && matchesTitle;
//                })
//                .map(this::mapToResponse)
//                .toList();
//    }

    // Create course
    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
//      1. Check course code
//      anyMatch return value in boolean
        boolean isCourseExisted = courseRepository.getCourses()
                .stream()
                .anyMatch(course -> course.getCode().equalsIgnoreCase(courseRequest.code()));
        if (isCourseExisted) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course code already existed");
        }


//      2. Map data from course request to domain model
        Course course = Course.builder()
                .id(UUID.randomUUID())
                .code(courseRequest.code())
                .title(courseRequest.title())
                .description(courseRequest.description())
                .price(courseRequest.price())
                .status(false)
                .build();
//      add mapped course into repo
        courseRepository.getCourses().add(course);


//      3. Map from domain model to course response
        return CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .build();
    }



    @Override
    public List<CourseResponse> filterCourses(String status, String title) {
        return courseRepository.getCourses().stream()
                .filter(course -> {
                    boolean matchesStatus = (status == null || status.isEmpty()) ||
                            (status.equalsIgnoreCase("true") && course.getStatus()) ||
                            (status.equalsIgnoreCase("false") && !course.getStatus());

                    boolean matchesTitle = (title == null || title.isEmpty()) ||
                            course.getTitle().toLowerCase().contains(title.toLowerCase());

                    return matchesStatus && matchesTitle;
                })
                .map(this::mapToResponse)
                .toList();
    }

    //4. Get course by code
    @Override
    public CourseResponse getCourseByCode(String code) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .map(this::mapToResponse)
                .orElse(null);
    }


    // Helper method
    private CourseResponse mapToResponse(Course course) {
        return CourseResponse.builder()
                .code(course.getCode())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .status(course.getStatus())
                .build();
    }

    // Delete course by code
    @Override
    public void deleteCourse(String code) {
        boolean isCourseExisted = courseRepository.getCourses()
                .removeIf(course -> course.getCode().equalsIgnoreCase(code));
        if (!isCourseExisted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found!");
        }

    }
}
