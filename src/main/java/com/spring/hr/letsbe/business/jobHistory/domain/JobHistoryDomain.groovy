package com.spring.hr.letsbe.business.jobHistory.domain

import com.spring.hr.letsbe.business.departments.domain.DepartmentsDomain
import com.spring.hr.letsbe.business.jobs.domain.JobsDomain

import javax.persistence.*

@Entity
@Table(name = 'job_history', schema = 'HR')
class JobHistoryDomain {

    @Id
    @Column(name = 'employee_id', length = 6, columnDefinition = 'number(6)')
    Long employeeId

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'start_date', columnDefinition = 'date')
    Date startDate

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'end_date', columnDefinition = 'date')
    Date endDate

    @ManyToOne
    @JoinColumn(name = 'job_id', columnDefinition = 'varchar2(10)')
    JobsDomain jobs

    @ManyToOne
    @JoinColumn(name = 'department_id', columnDefinition = 'number(4)')
    DepartmentsDomain department

}
