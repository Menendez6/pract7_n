package pat.practicas.pract7.service.impl;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pat.practicas.pract7.repository.CoursesRepository;
import pat.practicas.pract7.service.CourseService;
import pat.practicas.pract7.service.dto.CourseDTO;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
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

    @Override
    public void addCourse(CourseDTO course) {
        String name = course.courseName();
		String semester = Integer.toString(course.semester());
		String degree = course.degree();
		jdbcTemplate.execute("INSERT INTO COURSES (COURSE_NAME,SEMESTER,DEGREE) VALUES ('"+name+"',"+semester+",'"+degree+"');");
        
    }
    
}
