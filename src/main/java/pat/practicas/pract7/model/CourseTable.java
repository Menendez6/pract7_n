package pat.practicas.pract7.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("COURSES")
public class CourseTable {
	private @Column("ID") @Id Long id;
	private @Column("COURSE_NAME") String courseName;
	private @Column("SEMESTER") Integer semester ;
    private @Column("DEGREE") String degree;
    public Long getId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public Integer getSemester() {
        return semester;
    }
    public String getDegree() {
        return degree;
    }

    
}
