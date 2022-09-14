package com.mongo.training;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.training.entity.Address;
import com.mongo.training.entity.Employee;
import com.mongo.training.entity.Salary;
import com.mongo.training.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableMongoRepositories
public class MongoTrainingApplication {

    Logger logger = LoggerFactory.getLogger(MongoTrainingApplication.class);

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;
    private final EmployeeRepo employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(MongoTrainingApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            var employee = Employee.builder()
                    .firstName("Mohammad")
                    .lastName("Alsharif")
                    .position("developer")
                    .addressList(Collections.singletonList(new Address("address")))
                    .salary(Salary.builder().net(18000.0).growth(21000.0).build())
                    .build();
//            mongoTemplate.insert(objectMapper.writeValueAsString(employee), "employee");
            mongoTemplate.insert(employee);
//            var insert = employeeRepo.save(employee);
//            logger.info(objectMapper.writeValueAsString(insert));
//            insert.setFirstName("Mohammad updated");
//            employeeRepo.save(insert);
            List<Employee> all = employeeRepo.findAll();
            logger.info(objectMapper.writeValueAsString(all));
        };
    }
}
