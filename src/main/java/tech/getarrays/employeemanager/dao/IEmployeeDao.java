package tech.getarrays.employeemanager.dao;


import tech.getarrays.employeemanager.model.Employee;

import java.util.List;


public interface IEmployeeDao  {

    Employee addEmployee(Employee employee);

    Employee updateEmlpoyee(Long id,Employee employee);

    Employee findEmployeeById(long id);

    List<Employee> findAllEmployees();

    void deleteEmployee(Long id);

}
