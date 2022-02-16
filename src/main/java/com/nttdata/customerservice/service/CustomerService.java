package com.nttdata.customerservice.service;

import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository repository;

    @Override
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return  repository.findById(id);
    } 

    @Override
    public Mono<Customer> create(Customer customer) {
        customer.setDate(LocalDate.now());
        return repository.save(customer);
    }

    @Override
    public Mono<Customer> update(String id, Customer customer) {
        return repository.findById(id).flatMap(newCustomer -> {
            customer.setId(newCustomer.getId());
            return repository.save(customer);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id).flatMap(customer -> repository.deleteById(customer.getId()));
    }
}
