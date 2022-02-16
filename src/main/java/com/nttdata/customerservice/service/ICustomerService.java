package com.nttdata.customerservice.service;

import com.nttdata.customerservice.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Flux<Customer> findAll();

    Mono<Customer> findById(String id);

    Mono<Customer> create(Customer customer);

    Mono<Customer> update(String id, Customer customer);

    Mono<Void> delete(String id);
}
