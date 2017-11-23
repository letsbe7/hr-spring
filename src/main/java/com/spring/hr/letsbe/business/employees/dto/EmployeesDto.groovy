package com.spring.hr.letsbe.business.employees.dto

import com.spring.hr.letsbe.business.employees.domain.EmployeesDomain

class EmployeesDto {

    Long employeeId
    String firstName
    String lastName
    String email
    String phoneNumber
    Date hireDate
    String jobId
    Long salary
    Long commissionPct
    Long managerId
    Long departmentId

    EmployeesDto() {}

    EmployeesDto(EmployeesDomain from) {
        this.employeeId = from.employeeId
        this.firstName = from.firstName
        this.lastName = from.lastName
        this.email = from.email
        this.phoneNumber = from.phoneNumber
        this.hireDate = from.hireDate
        this.jobId = from.jobs?.jobId
        this.salary = from.salary
        this.commissionPct = from.commissionPct
        this.managerId = from.managerId
        this.departmentId = from.department?.departmentId
    }

    @Override
    public String toString() {
        return "EmployeesDto{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }
}
