package com.main.service;

import com.main.entity.Customer;
import com.main.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer registerCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> login(String email, String password) {
        return repository.findByEmail(email)
                .filter(customer -> customer.getPassword().equals(password));
    }
}
