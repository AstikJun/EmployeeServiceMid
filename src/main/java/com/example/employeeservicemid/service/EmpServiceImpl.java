package com.example.employeeservicemid.service;


import com.example.employeeservicemid.entity.Employee;
import com.example.employeeservicemid.repository.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{

    private EmpRepository employeeRepository;

    public EmpServiceImpl(EmpRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmpById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteEmpById(Long id) {
        employeeRepository.deleteById(id);
    }
}
