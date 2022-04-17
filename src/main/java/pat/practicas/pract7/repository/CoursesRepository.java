package pat.practicas.pract7.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pat.practicas.pract7.model.CourseTable;

@Repository
public interface CoursesRepository extends CrudRepository<CourseTable, Long>{
    
}
