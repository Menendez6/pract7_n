package pat.practicas.pract7.service.impl;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pat.practicas.pract7.repository.CustomersRepository;
import pat.practicas.pract7.service.CustomerService;
import pat.practicas.pract7.service.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomersRepository customersRepository;

	/*@Autowired
	private CoursesRepository coursesRepository;*/

	@Override
	public List<CustomerDTO> getCustomers() {
		return StreamSupport.stream(customersRepository.findAll().spliterator(), false)
				.map(obj -> new CustomerDTO(
						obj.getId(),
						obj.getCustomerName(),
						obj.getCustomerPassword(),
						obj.getCustomerEmail()))
				.toList();
	}

	@Override
	public void addCustomer(CustomerDTO customer) {
		//String Id = Long.toString(customer.id());
		String name = customer.customerName();
		String pass = customer.customerPassword();
		String email = customer.customerEmail();
		jdbcTemplate.execute("INSERT INTO CUSTOMERS (CUSTOMER_NAME,CUSTOMER_PASSWORD,CUSTOMER_EMAIL) VALUES ('"+name+"','"+pass+"','"+email+"'); ");
		
	}
}
