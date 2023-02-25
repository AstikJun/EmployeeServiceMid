package com.example.employeeservicemid.controller;


import com.example.employeeservicemid.entity.Employee;
import com.example.employeeservicemid.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {

    private EmpService employeeservice;

    public EmpController(EmpService employeeservice) {
        super();
        this.employeeservice = employeeservice;
    }

    @GetMapping("/")
    public String listEmp(Model model) {
        model.addAttribute("employees", employeeservice.getAllEmp());
        return "index";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/new")
    public String createEmpFor(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_emp";
    }

    @PostMapping("/")
    public String saveEmp(@ModelAttribute("employee") Employee employee) {
        employeeservice.saveEmp(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmpForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeservice.getEmpById(id));
        return "update_emp";
    }

    @PostMapping("/{id}")
    public String updateEmp(@PathVariable Long id,
                            @ModelAttribute("employee") Employee employee,
                            Model model) {

        Employee existingEmp = employeeservice.getEmpById(id);
        existingEmp.setId(id);
        existingEmp.setFirstName(employee.getFirstName());
        existingEmp.setLastName(employee.getLastName());
        existingEmp.setEmail(employee.getEmail());

        employeeservice.updateEmp(employee);
        return "redirect:/";
    }


    @GetMapping("/{id}")
    public String deleteEmp(@PathVariable Long id) {
        employeeservice.deleteEmpById(id);
        return "redirect:/";
    }
}
