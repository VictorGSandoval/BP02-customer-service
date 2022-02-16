package com.nttdata.customerservice.controller;


import com.nttdata.customerservice.model.Customer;
import com.nttdata.customerservice.service.ICustomerService;
import com.nttdata.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService service;

    @GetMapping
    public Flux<Customer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable String id, @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
