package com.spring.hr.letsbe.batch.repository

import com.spring.hr.letsbe.batch.domain.PeopleTC
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface PersonRepository extends JpaRepository<PeopleTC, Long> {

}
