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
@Table("CUSTOMERS")
public class CustomerTable {
	private @Column("ID") @Id Long id;
	private @Column("CUSTOMER_NAME") String customerName;
	private @Column("CUSTOMER_PASSWORD") String customerPassword;
    private @Column("CUSTOMER_EMAIL") String customerEmail;
    public Long getId() {
        return id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }

    
}
