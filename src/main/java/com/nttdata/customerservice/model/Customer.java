package com.nttdata.customerservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Customer {
    @Id
    private String id;
    private String fullname;
    private CustomerTypeDocument typeDocument;
    private String numDocument;
    private CustomerType typeCustomer;
    private CustomerTypePerfil typePerfil;
    private LocalDate date;
}
