package com.spring.hr.letsbe.business.test.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'TB_PEOPLE', schema = 'HR')
class PeopleDomain {

    @Id
    @Column(name = 'person_id')
    Long personId

    @Column(name = 'first_name')
    String firstName

    @Column(name = 'last_name')
    String lastName

}
