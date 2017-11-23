package com.spring.hr.letsbe.business.test.domain

import com.google.common.base.MoreObjects

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name='TB_TEST')
class TestDomain {

    @Id
    @Column(name='key', nullable = false)
    String key

    @Column(name='value', nullable = false)
    String value

    @Override
    String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", this.key)
                .add("value", this.value)
                .toString()
    }
}
