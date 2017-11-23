package com.spring.hr.letsbe.business.employees.domain

import com.google.common.base.MoreObjects
import com.google.common.base.Objects
import com.spring.hr.letsbe.business.departments.domain.DepartmentsDomain
import com.spring.hr.letsbe.business.jobs.domain.JobsDomain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name="EMPLOYEES", schema = 'HR')
class EmployeesDomain {

    @Id
    @Column(name = 'employee_id', length = 6, columnDefinition = 'number(6)')
    Long employeeId

    @Column(name = 'first_name', columnDefinition = 'varchar2(20)')
    String firstName

    @Column(name = 'last_name', columnDefinition = 'varchar2(20)')
    String lastName

    @Column(name = 'email', columnDefinition = 'varchar2(25)')
    String email

    @Column(name = 'phone_number', columnDefinition = 'varchar2(20)')
    String phoneNumber

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'hire_date')
    Date hireDate

    @ManyToOne
    @JoinColumn(name = 'job_id')
    JobsDomain jobs

    @Column(name = 'salary', columnDefinition = 'number(8,2)')
    Long salary

    @Column(name = 'commission_pct', columnDefinition = 'number(2,2)')
    Long commissionPct

    @Column(name = 'manager_id',  columnDefinition = 'number(6)')
    Long managerId

    /*
    @Column(name = 'department_id', columnDefinition = 'number(4)')
    Long departmentId
    */
    @ManyToOne
    @JoinColumn(name = 'department_id', columnDefinition = 'number(4)')
    DepartmentsDomain department

    @Override
    public String toString() {
        return "EmployeesDomain{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobs=" + jobs +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", department=" + department +
                '}';
    }
}
