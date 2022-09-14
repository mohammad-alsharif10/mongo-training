package com.mongo.training.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String position;
    private Salary salary;
    private List<Address>addressList= new ArrayList<>();
}
