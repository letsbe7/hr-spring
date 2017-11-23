package com.spring.hr.letsbe.business.countries.domain

import com.google.common.collect.Lists
import com.spring.hr.letsbe.business.locations.domain.LocationsDomain
import com.spring.hr.letsbe.business.regions.domain.RegionsDomail

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = 'countries', schema = 'HR')
class CountriesDomain {

    @Id
    @Column(name = 'country_id', length = 2, columnDefinition = 'char(2)')
    String countryId

    @Column(name = 'country_name', length = 40, columnDefinition = 'varchar2(40)')
    String countryName

    @ManyToOne
    @JoinColumn(name = 'region_id')
    RegionsDomail region

    @OneToMany(mappedBy = 'country')
    List<LocationsDomain> locations = Lists.newArrayList()

    void addLocation (LocationsDomain location) {
        this.locations.add(location)
        if (location.country != this) {
            locations.country = this
        }
    }

}
