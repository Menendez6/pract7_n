package pat.practicas.pract7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pat.practicas.pract7.service.CourseService;
import pat.practicas.pract7.service.dto.CourseDTO;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService course;
    
    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getCourses(){
        
        var courses = course.getCourses();
        
        return ResponseEntity.ok().body(courses);
    }
}
