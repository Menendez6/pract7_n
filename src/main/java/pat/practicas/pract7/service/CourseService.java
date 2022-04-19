package pat.practicas.pract7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pat.practicas.pract7.service.dto.CourseDTO;
import pat.practicas.pract7.service.dto.CoursesJoinDTO;

@Service
public interface CourseService {
    
    List<CourseDTO> getCourses();

    List<CoursesJoinDTO> getAllCourses();

    List<CoursesJoinDTO> getAllCourses2();

    CourseDTO getCourseById(Long Id);

    void addCourse(CourseDTO course);

    void deleteCourse(String name);

    void updateCourse(CourseDTO course);
}
