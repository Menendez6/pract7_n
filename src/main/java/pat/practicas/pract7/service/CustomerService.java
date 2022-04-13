package pat.practicas.pract7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pat.practicas.pract7.service.dto.CustomerDTO;

@Service
public interface CustomerService {

    //All data from Customer Table
    List<CustomerDTO> getCustomers();

    void addCustomer(CustomerDTO customer);


    //All Customers with Orders
    //List<CustomerDTO> getCustomersWithOrders();
}
