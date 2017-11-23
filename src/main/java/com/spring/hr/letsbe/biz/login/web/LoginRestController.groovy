package com.spring.hr.letsbe.biz.login.web

import com.spring.hr.letsbe.biz.login.service.LoginService
import com.spring.hr.letsbe.business.employees.domain.EmployeesDomain
import com.spring.hr.letsbe.business.employees.dto.EmployeesDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpSession

@RestController
class LoginRestController {

    @Autowired
    LoginService loginService

    @RequestMapping(value='/login', method = RequestMethod.POST)
    def requestLogin (HttpSession session, @RequestBody EmployeesDto dto) {
        System.out.println("requestDto: ${dto}")
        EmployeesDto found = loginService.procLogin(dto)
        session.setAttribute('employee', found)
        return found
    }

    @RequestMapping('/logout')
    def requestLogout (EmployeesDomain dto) {
        return true
    }


}
