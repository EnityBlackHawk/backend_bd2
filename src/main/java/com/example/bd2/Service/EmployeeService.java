package com.example.bd2.Service;

import com.example.bd2.Model.Employee;
import com.example.bd2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(@Autowired EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee FindById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Employee> FindAll() {
        return repository.findAll();
    }

    public Employee Add(Employee employee) {
        return repository.save(employee);
    }

    public void Delete(Long id) {
        repository.deleteById(id);
    }

    public Employee Update(Employee employee) {
        return repository.save(employee);
    }

    public Employee findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
