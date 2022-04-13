package pat.practicas.pract7.service.impl;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pat.practicas.pract7.repository.CoursesRepository;
import pat.practicas.pract7.service.CourseService;
import pat.practicas.pract7.service.dto.CourseDTO;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
	private CoursesRepository coursesRepository;

    @Override
    public List<CourseDTO> getCourses() {
        return StreamSupport.stream(coursesRepository.findAll().spliterator(), false)
				.map(obj -> new CourseDTO(
						obj.getId(),
						obj.getCourseName(),
						obj.getSemester(),
						obj.getDegree()))
				.toList();
    }
    
}
