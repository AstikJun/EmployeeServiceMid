package com.example.employeeservicemid.bootstrap;


import com.example.employeeservicemid.entity.Employee;
import com.example.employeeservicemid.repository.EmpRepository;
import com.example.employeeservicemid.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpBootstrap implements CommandLineRunner {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpRepository empRepository;
    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee("Adilet","Torobaev","adik@gmail.com","Jubek Jolu","IT");
        Employee employee1 = new Employee("Almanbet","Totoev","alma@gmail.com","10mkr","IT");
        Employee employee2 = new Employee("Asel","Alybaeva","asel@gmail.com","Vefa","Marketing");
        Employee employee3 = new Employee("Aigerim","Nuralieva","aigerim@gmail.com","6mkr","HR");
        Employee employee4 = new Employee("Astan","Serikov","serikov@gmail.com","5mrk","IT");
        empRepository.save(employee);
        empRepository.save(employee1);
        empRepository.save(employee2);
        empRepository.save(employee3);
        empRepository.save(employee4);

    }
}
