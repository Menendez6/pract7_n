package pat.practicas.pract7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pat.practicas.pract7.model.CourseTable;
import pat.practicas.pract7.repository.CoursesRepository;
import pat.practicas.pract7.service.CourseService;
import pat.practicas.pract7.service.dto.CourseDTO;
import pat.practicas.pract7.service.dto.CoursesJoinDTO;

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

    @PostMapping("/update_course")
    public @ResponseBody ResponseEntity<String> updateCourse(@RequestBody CourseDTO course){
        courseService.updateCourse(course);
        
        return ResponseEntity.ok().body("Curso actualizado"); 
        
    } 

    @Transactional
    @GetMapping("courses/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") Long id) {

        var course = courseService.getCourseById(id);

        return ResponseEntity.ok().body(course);
    }

    @GetMapping("courses/all")
    public ResponseEntity<List<CoursesJoinDTO>> getAllCourses(){

        var courses = courseService.getAllCourses();

        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("courses/all2")
    public ResponseEntity<List<CoursesJoinDTO>> getAllCourses2(){

        var courses = courseService.getAllCourses2();

        return ResponseEntity.ok().body(courses);
    }
}
