package com.parameta.employee.rest.employee;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Rest controller for the Employee entity.
 */

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    /**
     * Default method for the /employee endpoint, no name(location) is specified.
     * */

    @GetMapping
    public DTOEmployee getEmployee(@ModelAttribute @Valid Employee employee) {
        return new DTOEmployee();
    }

}
