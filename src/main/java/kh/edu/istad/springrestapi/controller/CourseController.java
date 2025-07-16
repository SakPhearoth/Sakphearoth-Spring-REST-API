package kh.edu.istad.springrestapi.controller;

import jakarta.validation.Valid;
import kh.edu.istad.springrestapi.dto.CourseRequest;
import kh.edu.istad.springrestapi.dto.CourseResponse;
import kh.edu.istad.springrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    //1. Define dependency
    //final keyword for required dependency
    private final CourseService courseService;

    //1. Get all course
    /*
    @GetMapping()
    public List<CourseResponse> getCourses(){
        return courseService.getCourses();
    }
    */


    //2. Get course by status
    /*
    @GetMapping("/status")
    public List<CourseResponse> getCourseByStatus(@RequestParam(required = false) String status){
        return courseService.getCourseByStatus(status);
    }
    */


    //3. Get course by title and status(optional)
    /*
    @GetMapping("/title")
    public List<CourseResponse> getCourseByTitle(@RequestParam(required = false) String status,
                                                 @RequestParam(required = false) String title){
        return courseService.getCourseByTitle(status, title);
    }
    */


    // Create course
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse createCourse(@Valid @RequestBody CourseRequest courseRequest) {

        return courseService.createCourse(courseRequest);
    }


    @GetMapping()
    public List<CourseResponse> getCourse(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String title
    ) {
        return courseService.filterCourses(status, title);
    }


    //4. Get course by code
    @GetMapping("{code}")
    public CourseResponse getCourseByCode(@PathVariable String code) {
        return courseService.getCourseByCode(code);
    }


    //5. Delete course by code
    @DeleteMapping("{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String code) {
        courseService.deleteCourse(code);
    }


}
