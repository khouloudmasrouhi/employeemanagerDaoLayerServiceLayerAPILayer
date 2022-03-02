package tech.getarrays.employeemanager.service;

import tech.getarrays.employeemanager.dto.EmployeeDto;
// ici on travail seulement avec les Dto et non pas entities

import java.util.List;

public interface IEmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto update(Long id,EmployeeDto employeeDto);

    EmployeeDto getById(long id);

    List<EmployeeDto> getAll();

    public void delete(Long id);
}
