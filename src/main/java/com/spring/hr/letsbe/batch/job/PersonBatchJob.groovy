package com.spring.hr.letsbe.batch.job

import com.spring.hr.letsbe.business.test.dto.PersonDto
import com.spring.hr.letsbe.batch.itemProcessors.PersonItemProcessor
import com.spring.hr.letsbe.business.test.repository.PersonRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

import javax.sql.DataSource

@Configuration
@EnableBatchProcessing
class PersonBatchJob {

    @Autowired
    JobBuilderFactory jobBuilderFactory

    @Autowired
    StepBuilderFactory stepBuilderFactory

    @Autowired
    PersonRepository personRepository

    @Autowired
    @Qualifier("orcl_hikari_ds")
    DataSource dataSource

    @Bean
    FlatFileItemReader<PersonDto> reader () {
        FlatFileItemReader<PersonDto> reader = new FlatFileItemReader<PersonDto>()
        reader.setResource(new ClassPathResource("sample-data.csv"))
        reader.setLineMapper(new DefaultLineMapper<PersonDto>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                String[] names = ['firstName', 'lastName']
                setNames(names)
            }})
            setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonDto>() {{
                setTargetType(PersonDto.class)
            }})
        }})
        return reader
    }

    @Bean
    PersonItemProcessor processor() {
        return new PersonItemProcessor()
    }

    @Bean
    JdbcBatchItemWriter<PersonDto> writer() {
        JdbcBatchItemWriter<PersonDto> writer = new JdbcBatchItemWriter<PersonDto>()
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PersonDto>())
        writer.setSql("INSERT INTO HR.TB_PEOPLE (person_id, first_name, last_name) VALUES (:personId, :firstName, :lastName)")
        writer.setDataSource(dataSource)
        return writer
    }

    @Bean
    Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build()
    }

    @Bean
    Step step1() {
        return stepBuilderFactory.get("step1")
                .<PersonDto, PersonDto> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build()
    }


}
