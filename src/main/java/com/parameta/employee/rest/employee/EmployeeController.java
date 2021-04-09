package com.parameta.employee.rest.employee;

import com.parameta.employee.rest.util.Utilities;
import com.parameta.employee.soap.client.EmployeeSOAPClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Rest controller for the Employee entity.
 * Will handle incoming SOAP requests.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    final EmployeeSOAPClient client;
    final Utilities utilities;

    /**
     * Autowired constructor to inject client and utilities components.
     * @param client The client to call the SOAP service.
     * @param utilities Useful utilities to make the service work.
     * */
    @Autowired
    public EmployeeController(EmployeeSOAPClient client, Utilities utilities) {
        this.client = client;
        this.utilities = utilities;
    }

    /**
     * Default GET method for the /employee endpoint, no name(location) is specified, will use default.
     * @param employee Employee mapped class from the incoming request.
     * @return DTOEmployee containing all fields in Employee class plus employmentDate and currentAge descriptions.
     * */
    @GetMapping
    public DTOEmployee getEmployee(@ModelAttribute @Valid DTOEmployee employee) {
        var response = client.createEmployee(employee);
        ModelMapper modelMapper = new ModelMapper();
        DTOEmployee dtoEmployee = modelMapper.map(response.getEmployee(), DTOEmployee.class);

        dtoEmployee.setBirthDate(response.getEmployee().getBirthDate().toGregorianCalendar().getTime());
        dtoEmployee.setEmploymentDate(response.getEmployee().getEmploymentDate().toGregorianCalendar().getTime());

        return dtoEmployee;
    }

}
