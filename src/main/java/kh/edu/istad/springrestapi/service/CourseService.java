package kh.edu.istad.springrestapi.service;

import kh.edu.istad.springrestapi.dto.CourseRequest;
import kh.edu.istad.springrestapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {

    //1. Get all courses
//    List<CourseResponse> getCourses();

    //2. task -> get course and filter by status (?status = true, false)
    // List<CourseResponse> getCourseByStatus(String status);

    //3. task -> filter (courses?status = "true"$title="Web design" no need to write full word.)
    //List<CourseResponse> getCourseByTitle(String status, String title);

    /**
     * Get all courses, a course by status, title, status + title
     * @param status
     * @param title
     */
    List<CourseResponse> filterCourses(String status, String title);

    //4. Get courses by id
    CourseResponse getCourseByCode(String code);


    // Filter by status


    /**
     * Create a new course
     *
     * @param courseRequest
     * @return CourseResponse
     */
    CourseResponse createCourse(CourseRequest courseRequest);


    /**
     * Delete a course
     */
    void deleteCourse(String code);

}
