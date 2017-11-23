package com.spring.hr.letsbe.business.jobs.repository

import com.spring.hr.letsbe.business.jobs.domain.JobsDomain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = '/jobs')
interface JobsRepository extends JpaRepository<JobsDomain, String> {

}
