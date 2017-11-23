package com.spring.hr.letsbe.business.jobs.domain

import com.google.common.collect.Lists
import com.spring.hr.letsbe.business.employees.domain.EmployeesDomain
import com.spring.hr.letsbe.business.jobHistory.domain.JobHistoryDomain

import javax.persistence.*

@Entity
@Table(name = 'jobs', schema = 'HR')
class JobsDomain {

    @Id
    @Column(name = 'job_id', columnDefinition = 'varchar2(10)')
    String jobId

    @Column(name = 'job_title', columnDefinition = 'varchar2(35)')
    String jobTitle

    @Column(name = 'min_salary', columnDefinition = 'number(6)', length = 6)
    Long minSalary

    @Column(name = 'max_salary', columnDefinition = 'number(6)', length = 6)
    Long maxSalary

    @OneToMany(mappedBy = 'jobs')
    List<EmployeesDomain> employees = Lists.newArrayList()

    @OneToMany(mappedBy = 'jobs')
    List<JobHistoryDomain> jobHistory = Lists.newArrayList()

    void addEmployee (EmployeesDomain employee) {
        this.employees.add(employee)
        if (employee.jobs != this) {
            employee.jobs = this
        }
    }

    void addJobHistory (JobHistoryDomain job) {
        this.jobHistory.add(job)
        if (job.jobs != this) {
            job.jobs = this
        }
    }

}
