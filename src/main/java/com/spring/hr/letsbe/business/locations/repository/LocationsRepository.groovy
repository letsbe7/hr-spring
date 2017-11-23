package com.spring.hr.letsbe.business.locations.repository

import com.spring.hr.letsbe.business.locations.domain.LocationsDomain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = '/locations')
interface LocationsRepository extends JpaRepository<LocationsDomain, Long> {

}
