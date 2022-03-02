package tech.getarrays.employeemanager.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.getarrays.employeemanager.dto.EmployeeDto;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    @Autowired
    private ModelMapper mapper;

    public Employee mapToEntity(EmployeeDto employeeDto){
        return mapper.map(employeeDto,Employee.class);
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        return mapper.map(employee,EmployeeDto.class);
    }

    public List<EmployeeDto> mapToListDto(List<Employee> employeeList){
        return employeeList.stream().map(this::mapToEmployeeDto).collect(Collectors.toList());
    }


    public List<Employee> mapToListEntity(List<EmployeeDto> employeeDtoList){
        return employeeDtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}
