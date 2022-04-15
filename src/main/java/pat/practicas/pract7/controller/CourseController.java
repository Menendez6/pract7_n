package pat.practicas.pract7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pat.practicas.pract7.service.CourseService;
import pat.practicas.pract7.service.dto.CourseDTO;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getCourses(){
        
        var courses = courseService.getCourses();
        
        return ResponseEntity.ok().body(courses);
    }

    @PostMapping("/add_course")
    public @ResponseBody ResponseEntity<String> addCourse(@RequestBody CourseDTO course){
        courseService.addCourse(course);
        
        return ResponseEntity.ok().body("Curso incluido"); 
        
    }

    @PostMapping("/delete_course")
    public @ResponseBody ResponseEntity<String> deleteCourse(@RequestBody String name){
        courseService.deleteCourse(name);
        
        return ResponseEntity.ok().body("Curso eliminado"); 
        
    } 
}
