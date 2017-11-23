package com.spring.hr.letsbe.business.departments.service

import com.spring.hr.letsbe.business.departments.repository.DepartmentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DepartmentsService {

    @Autowired
    DepartmentsRepository departmentsRepository


}
