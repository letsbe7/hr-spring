package com.spring.hr.letsbe.business.test.repository;

import com.spring.hr.letsbe.business.test.domain.TestDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/test")
interface TestRepository extends JpaRepository<TestDomain, String> {

}
