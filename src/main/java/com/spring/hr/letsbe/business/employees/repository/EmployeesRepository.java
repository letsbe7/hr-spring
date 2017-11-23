package com.spring.hr.letsbe.business.employees.repository;

import com.spring.hr.letsbe.business.employees.domain.EmployeesDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/employees")
public interface EmployeesRepository extends JpaRepository<EmployeesDomain, Long> {

}
