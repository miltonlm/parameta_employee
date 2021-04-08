package com.parameta.employee.soap;

import com.parameta.employee.rest.employee.Employee;
import com.parameta.employee.rest.employee.EmployeeRepository;
import com.parameta.soap.CreateEmployeeRequest;
import com.parameta.soap.CreateEmployeeResponse;
import com.parameta.soap.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class EmployeeEndpoint {
    private static final String NAMESPACE_URI = "http://parameta.com/soap";

    @Autowired
    EmployeeRepository employeeRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {
        try {
            CreateEmployeeResponse response = new CreateEmployeeResponse();
            Status status = new Status();
            ModelMapper modelMapper = new ModelMapper();
            Employee employeeEntity = modelMapper.map(request.getEmployee(), Employee.class);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            List<String> errors = validator.validate(employeeEntity).stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

            if (errors.size() == 0) {
                Employee newEmployeeEntity = employeeRepository.save(employeeEntity);
                com.parameta.soap.Employee newEmployee = modelMapper.map(request.getEmployee(), com.parameta.soap.Employee.class);

                newEmployee.setId(newEmployeeEntity.getId());
                status.setStatus("success");
                response.setEmployee(newEmployee);
            } else {
                status.setStatus("error");
                status.getErrors().addAll(errors);
            }

            response.setStatus(status);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
