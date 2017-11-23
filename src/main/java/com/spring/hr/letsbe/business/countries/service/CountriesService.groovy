package com.spring.hr.letsbe.business.countries.service

import com.spring.hr.letsbe.business.countries.repository.CountriesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountriesService {

    @Autowired
    CountriesRepository countriesRepository

}
