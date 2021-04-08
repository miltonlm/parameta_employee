package com.parameta.employee.rest.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Employee entity model
 * */

@Entity
public class Employee {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name is required")
    @Size(min = 2, message = "name length must be greater than 1")
    private String name;
    @NotBlank(message = "lastName is required")
    @Size(min = 2, message = "lastName length must be greater than 1")
    private String lastName;
    @NotBlank(message = "identificationType is required")
    private String identificationType;
    @NotBlank(message = "identification is required")
    private String identification;
    @NotNull(message = "birthDate can not be null and valid format must be sent [yyy-mm-dd]")
    private Date birthDate;
    @NotNull(message = "employmentDate can not be null and valid format must be sent [yyy-mm-dd]")
    private Date employmentDate;
    @NotBlank(message = "position is required")
    private String position;
    @NotNull(message = "salary is required")
    @Min(value = 1, message = "salary must be greater than 0")
    private Double salary;

    public Employee() {
    }

    public Employee(Long id, String name, String lastName, String identificationType, String identification, Date birthDate, Date employmentDate, String position, Double salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identification = identification;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.position = position;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
