package com.parameta.employee.soap.client;

import com.parameta.employee.rest.employee.DTOEmployee;
import com.parameta.employee.soap.generated.CreateEmployeeRequest;
import com.parameta.employee.soap.generated.CreateEmployeeResponse;
import com.parameta.employee.soap.generated.EmployeeType;
import org.modelmapper.ModelMapper;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


/**
 * The client class that calls the SOAP endpoint.
 * */
public class EmployeeSOAPClient extends WebServiceGatewaySupport {

    /**
     * The method that calls the SOAP endpoint.
     *
     * @param employee DTOEmployee to create.
     * @return CreateEmployeeResponse the response from the SOAP endpoint.
     * */
    public CreateEmployeeResponse createEmployee(DTOEmployee employee) {
        ModelMapper modelMapper = new ModelMapper();
        EmployeeType employeeType = modelMapper.map(employee, EmployeeType.class);

        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmployee(employeeType);

        return (CreateEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
