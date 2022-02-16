package com.nttdata.customerservice.repository;

import com.nttdata.customerservice.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

}