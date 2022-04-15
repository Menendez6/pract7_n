package pat.practicas.pract7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pat.practicas.pract7.service.CustomerService;
import pat.practicas.pract7.service.dto.CustomerDTO;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {

        var orders = customerService.getCustomers();

        return ResponseEntity.ok().body(orders);
    }


    @PostMapping("/customers")
    public @ResponseBody ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customer){
        customerService.addCustomer(customer);
        
        return ResponseEntity.ok().body("Aplicante incluido"); 
        
    }


}
