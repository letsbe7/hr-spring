package com.spring.hr.letsbe.business.regions.repository

import com.spring.hr.letsbe.business.regions.domain.RegionsDomail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = '/regions')
interface RegionsRepository extends JpaRepository<RegionsDomail, Long> {

}
