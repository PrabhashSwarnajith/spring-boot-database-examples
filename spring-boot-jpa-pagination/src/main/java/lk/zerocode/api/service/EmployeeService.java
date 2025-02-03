package lk.zerocode.api.service;

import lk.zerocode.api.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllBy();

    List<Employee> findAllBy(Pageable pageable);

    List<Employee> findAllByMinSalary(Long minSalary, Pageable pageable);

    List<Employee> findAllBy(Sort sort);

    void create(Employee employee);
}
