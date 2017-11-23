package com.spring.hr.letsbe.business.test.dao;

import com.spring.hr.letsbe.business.test.domain.TestDomain;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDaoImpl implements TestDao {

    private final String namespace = "com.spring.hr.letsbe.business.test.dao.TestDao";

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @Override
    public List<TestDomain> findAll() {
        return sessionTemplate.selectList(namespace + "findAll");
    }
}
