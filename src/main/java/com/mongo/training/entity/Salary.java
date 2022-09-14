package com.mongo.training.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Salary {

    private Double net;
    private Double growth;
}
