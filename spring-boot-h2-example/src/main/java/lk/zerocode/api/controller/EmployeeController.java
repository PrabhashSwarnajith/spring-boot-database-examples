package lk.zerocode.api.controller;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public void create() {
        Employee employee1 = new Employee();
        employee1.setName("Emp1");

        Employee employee2 = new Employee();
        employee2.setName("Emp2");

        employeeRepository.saveAll(List.of(employee1, employee2));
    }
}
