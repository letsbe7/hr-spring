package com.spring.hr.letsbe.biz.login.service

import com.google.common.base.Preconditions
import com.spring.hr.letsbe.business.employees.domain.EmployeesDomain
import com.spring.hr.letsbe.business.employees.dto.EmployeesDto
import com.spring.hr.letsbe.business.employees.repository.EmployeesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService {

    @Autowired
    EmployeesRepository employeeRepository

    EmployeesDto procLogin (EmployeesDto dto) {
        EmployeesDomain found = employeeRepository.findOne(dto.employeeId)
        Preconditions.checkNotNull(found, "존재하지 않는 사번입니다.")
        return new EmployeesDto(found)
    }

}
