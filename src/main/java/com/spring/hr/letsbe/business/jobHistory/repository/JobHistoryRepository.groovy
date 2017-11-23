package com.spring.hr.letsbe.business.jobHistory.repository

import com.spring.hr.letsbe.business.jobHistory.domain.JobHistoryDomain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = '/jobHistory')
interface JobHistoryRepository extends JpaRepository<JobHistoryDomain, Long> {
}
