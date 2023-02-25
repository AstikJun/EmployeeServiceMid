package com.example.employeeservicemid.service;


import com.example.employeeservicemid.entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> getAllEmp();

    Employee saveEmp(Employee employee);

    Employee getEmpById(Long id);

    Employee updateEmp(Employee employee);

    void deleteEmpById(Long id);
}
