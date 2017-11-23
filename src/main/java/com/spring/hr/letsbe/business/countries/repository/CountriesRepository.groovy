package com.spring.hr.letsbe.business.countries.repository

import com.spring.hr.letsbe.business.countries.domain.CountriesDomain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = '/countries')
interface CountriesRepository extends JpaRepository<CountriesDomain, String> {

}
