package lk.zerocode.api.service.impl;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> findAllBy() {
        return repository.findAll();
    }

    @Override
    public void create(Employee employee) {
        repository.save(employee);
    }

    @Override
    public List<Employee> findAllBy(Pageable pageable) {
        Page<Employee> employeePage = repository.findAllBy(pageable);
        System.out.println("total pages  : " + employeePage.getTotalPages());
        System.out.println("total elements : " + employeePage.getTotalPages());
        System.out.println("current page " + employeePage.getNumber());
        System.out.println("page size " + employeePage.getNumberOfElements());
        return employeePage.getContent();
    }

    @Override
    public List<Employee> findAllByMinSalary(Long minSalary, Pageable pageable) {
        return repository.findAllByMinSalary(minSalary, pageable);
    }

    @Override
    public List<Employee> findAllBy(Sort sort) {
        return repository.findAllBy(sort);
    }
}
