package com.spring.hr.letsbe.business.test.repository

import com.spring.hr.letsbe.business.test.domain.PeopleDomain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = 'people')
interface PersonRepository extends JpaRepository<PeopleDomain, Long> {

}
