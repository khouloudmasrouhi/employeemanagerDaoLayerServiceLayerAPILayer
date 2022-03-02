package tech.getarrays.employeemanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;
import java.util.List;



@Component
public class EmployeeDaoImpl implements IEmployeeDao {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeDaoImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmlpoyee(Long id,Employee employee) {
        Employee employee1 = employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee id"+ id+"was not found"));

        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setJobTitle(employee.getJobTitle());
        employee1.setPhone(employee.getPhone());
        employee1.setImageUrl(employee.getImageUrl());
        employee1.setEmployeeCode(employee.getEmployeeCode());
        return employeeRepo.save(employee1);
    }


    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
