package com.spring.hr.letsbe.business.departments.repository

import com.spring.hr.letsbe.business.departments.domain.DepartmentsDomain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = '/departments')
interface DepartmentsRepository extends JpaRepository<DepartmentsDomain, Long> {

}
