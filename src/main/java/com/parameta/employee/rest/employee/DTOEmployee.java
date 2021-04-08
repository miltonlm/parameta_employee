package com.parameta.employee.rest.employee;

import java.util.Date;

/**
 * DTOEmployee to transfer the Employee entity adding two additional fields:
 * employmentTime describing how much time the employee has in the company
 * currentAge to describe how old the employee is.
 * */

public class DTOEmployee {
    private Long id;
    private String name;
    private String lastName;
    private String identificationType;
    private String identification;
    private Date birthDate;
    private Date employmentDate;
    private String position;
    private Double salary;
    private String employmentTime;
    private String currentAge;

    public DTOEmployee() {
    }

    public DTOEmployee(Long id, String name, String lastName, String identificationType, String identification, Date birthDate, Date employmentDate, String position, Double salary, String employmentTime, String currentAge) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identification = identification;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.position = position;
        this.salary = salary;
        this.employmentTime = employmentTime;
        this.currentAge = currentAge;
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

    public String getEmploymentTime() {
        return employmentTime;
    }

    public void setEmploymentTime(String employmentTime) {
        this.employmentTime = employmentTime;
    }

    public String getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }
}
