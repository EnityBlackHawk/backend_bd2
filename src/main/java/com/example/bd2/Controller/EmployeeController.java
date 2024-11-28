package com.example.bd2.Controller;

import com.example.bd2.Model.Employee;
import com.example.bd2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Value("${product-api.url}")
    private String produtosUrl;
    private EmployeeService service;

    public EmployeeController(@Autowired EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/getProdutosUrl")
    public String getProdutosUrl() {
        return produtosUrl;
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return service.FindAll();
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return service.Add(employee);
    }

}
