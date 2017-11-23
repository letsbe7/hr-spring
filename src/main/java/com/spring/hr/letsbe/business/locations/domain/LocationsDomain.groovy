package com.spring.hr.letsbe.business.locations.domain

import com.google.common.collect.Lists
import com.spring.hr.letsbe.business.countries.domain.CountriesDomain
import com.spring.hr.letsbe.business.departments.domain.DepartmentsDomain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = 'locations', schema = 'HR')
class LocationsDomain {

    @Id
    @Column(name = 'location_id', columnDefinition = 'number(4)', length = 4)
    Long locationId

    @Column(name = 'street_address', columnDefinition = 'varchar2(40)')
    String streetAddress

    @Column(name = 'postal_code', columnDefinition = 'varchar2(12)')
    String postalCode

    @Column(name = 'city', columnDefinition = 'varchar(30)')
    String city

    @Column(name = 'state_province', columnDefinition = 'varchar2(25)')
    String stateProvince

    @ManyToOne
    @JoinColumn(name = 'country_id')
    CountriesDomain country

    @OneToMany(mappedBy = 'location')
    List<DepartmentsDomain> departments = Lists.newArrayList()

    void addDepartment (DepartmentsDomain department) {
        this.departments.add(department)
        if (department.location != this) {
            department.location = this
        }
    }



}
