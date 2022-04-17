package pat.practicas.pract7.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("COURSCUST")
public class CoursCustTable {
	private @Column("CUSTOMER_ID") Long idCustomer;
	private @Column("COURSE_ID") Long idCourse;

    public Long getIdCustomer(){
        return idCustomer;
    }

    public Long getIdCourse(){
        return idCourse;
    }

    
}

