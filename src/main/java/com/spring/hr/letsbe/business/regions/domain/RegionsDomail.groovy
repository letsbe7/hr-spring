package com.spring.hr.letsbe.business.regions.domain

import com.spring.hr.letsbe.business.countries.domain.CountriesDomain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = 'Regions', schema = 'HR')
class RegionsDomail {

    @Id
    @Column(name = 'region_id')
    Long regionId

    @Column(name = 'region_name')
    String regionName

    @OneToMany(mappedBy = 'region')
    List<CountriesDomain> countries

    void addCountry (CountriesDomain country) {
        this.countries.add(country)
        if (country.region != this) {
            country.region = this
        }

    }

}
