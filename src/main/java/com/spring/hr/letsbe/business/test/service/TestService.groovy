package com.spring.hr.letsbe.business.test.service

import com.spring.hr.letsbe.business.test.dao.TestDao
import com.spring.hr.letsbe.business.test.domain.TestDomain
import com.spring.hr.letsbe.business.test.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService {

    @Autowired
    TestRepository testRepository

    @Autowired
    TestDao testDao


    List<TestDomain> findAll () {
        return testDao.findAll()
    }



}
