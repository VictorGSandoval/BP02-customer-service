package com.nttdata.customerservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
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
