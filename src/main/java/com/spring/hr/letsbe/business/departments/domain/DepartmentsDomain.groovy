package com.spring.hr.letsbe.business.departments.domain

import com.google.common.collect.Lists
import com.spring.hr.letsbe.business.employees.domain.EmployeesDomain
import com.spring.hr.letsbe.business.jobHistory.domain.JobHistoryDomain
import com.spring.hr.letsbe.business.locations.domain.LocationsDomain

import javax.persistence.*

@Entity
@Table(name = 'departments', schema = 'HR')
class DepartmentsDomain {

    @Id
    @Column(name = 'department_id', length = 4, columnDefinition = 'number(4)')
    Long departmentId

    @Column(name = 'department_name', columnDefinition = 'varchar2(30)')
    String departmentName

    @Column(name = 'manager_id', columnDefinition = 'number(6)')
    Long managerId

    /*
    @Column(name = 'location_id', columnDefinition = 'number(4)')
    Long locationId
    */
    @ManyToOne
    @JoinColumn(name = 'location_id', columnDefinition = 'number(4)')
    LocationsDomain location

    @OneToMany(mappedBy = 'department')
    List<JobHistoryDomain> jobHistories = Lists.newArrayList()

    @OneToMany(mappedBy = 'department')
    List<EmployeesDomain> employees = Lists.newArrayList()


    void addJobHistory (JobHistoryDomain jobHist) {
        this.jobHistories.add(jobHist)
        if (jobHist.department != this) {
            jobHist.department = this
        }
    }

    void addEmpoyee (EmployeesDomain employee) {
        this.employees.add(employee)
        if (employee.department != this) {
            employee.department = this
        }
    }


}
