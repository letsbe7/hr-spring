package com.spring.hr.letsbe.business.jobHistory.service

import com.spring.hr.letsbe.business.jobHistory.repository.JobHistoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class JobHistoryService {

    @Autowired
    JobHistoryRepository jobHistoryRepository

}
