package pat.practicas.pract7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pat.practicas.pract7.service.dto.CourseDTO;

@Service
public interface CourseService {
    
    List<CourseDTO> getCourses();
}
