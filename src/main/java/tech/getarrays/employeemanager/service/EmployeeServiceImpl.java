package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.dao.EmployeeDaoImpl;
import tech.getarrays.employeemanager.dto.EmployeeDto;
import tech.getarrays.employeemanager.mapper.EmployeeMapper;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{


    private final EmployeeDaoImpl employeeDao;
    private final EmployeeMapper employeeMapper;


    @Autowired
    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao, EmployeeMapper employeeMapper) {
        this.employeeDao = employeeDao;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeDao.addEmployee(employeeMapper.mapToEntity(employeeDto));
        return employeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto update(Long id,EmployeeDto employeeDto) {

        Employee employeeRequest = employeeMapper.mapToEntity(employeeDto);
        Employee employee = employeeDao.updateEmlpoyee(id,employeeRequest);
        return employeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public EmployeeDto getById(long id) {
        return employeeMapper.mapToEmployeeDto(employeeDao.findEmployeeById(id));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeMapper.mapToListDto(employeeDao.findAllEmployees());

    }

    @Override
    public void delete(Long id) {
        employeeDao.deleteEmployee(id);
    }
}
