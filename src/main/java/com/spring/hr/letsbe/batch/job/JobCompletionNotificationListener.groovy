package com.spring.hr.letsbe.batch.job

import com.spring.hr.letsbe.batch.dto.PersonDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component

import java.sql.ResultSet
import java.sql.SQLException

@Component
class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class)

    private final JdbcTemplate jdbcTemplate

    @Autowired
    JobCompletionNotificationListener (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate
    }


    void afterJob (JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results")

            List<PersonDto> results = jdbcTemplate.query("SELECT first_name, last_name FROM HR.TB_PEOPLE", new RowMapper<PersonDto>() {
                @Override
                PersonDto mapRow(ResultSet rs, int row) throws SQLException {
                    return new PersonDto(firstName: rs.getString(1), lastName: rs.getString(2))
                }
            })

            for (PersonDto person : results) {
                log.info("Found <${person}> in the database.")
            }
        }
    }


}
