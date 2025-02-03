package lk.zerocode.api.controller;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //only pagination
    @GetMapping(value = "/employees", headers = "X-Api-Version=v1")
    public List<Employee> getEmployees(@RequestParam("page") Integer page,
                                       @RequestParam("size") Integer size) {
        return employeeService.findAllBy(PageRequest.of(page, size));
    }

    //ony sorting
    @GetMapping(value = "/asc-sort-employees", headers = "X-Api-Version=v1")
    public List<Employee> getSortedEmployees() {
        return employeeService.findAllBy(Sort.by(Sort.Order.asc("salary")));
    }

    //both sorting and pagination
    @GetMapping(value = "/page-and-sort-employees", headers = "X-Api-Version=v1")
    public List<Employee> getPageAndSortEmployees(@RequestParam("page") Integer page,
                                                  @RequestParam("size") Integer size) {

        Sort sort = Sort.by(Sort.Order.asc("salary"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return employeeService.findAllBy(pageRequest);
    }


    //both sorting and pagination (with custom query)
    @GetMapping(value = "/min-salary-employees", headers = "X-Api-Version=v1")
    public List<Employee> getEmployeesByCustomQuery(@RequestParam("salary") Long minSalary,
                                                    @RequestParam("page") Integer page,
                                                    @RequestParam("size") Integer size) {

//        Sort sort = Sort.by("salary").descending();
//        Sort sort = Sort.by("salary").ascending().and(Sort.by("abc").descending());
        Sort sort = Sort.by("salary").ascending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return employeeService.findAllByMinSalary(minSalary, pageRequest);
    }


    @PostMapping(value = "/test-data", headers = "X-Api-version=v1")
    public void insertTestData() {

        for (int i = 1; i <= 1000; i++) {
            Employee employee = new Employee();
            employee.setName("name " + i);
            employee.setSalary(generateRandomSalary(500, 1500));
            employeeService.create(employee);
        }
    }

    public Long generateRandomSalary(int minSalary, int maxSalary) {
        int range = maxSalary - minSalary;
        return (long) (minSalary + (Math.random() * range));
    }
}
