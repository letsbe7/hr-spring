package com.spring.hr.letsbe.batch.itemProcessors

import com.spring.hr.letsbe.business.test.dto.PersonDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor

import java.util.concurrent.atomic.AtomicInteger


class PersonItemProcessor implements  ItemProcessor<PersonDto, PersonDto> {


    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class)

    AtomicInteger seq = new AtomicInteger()


    @Override
    PersonDto process (final PersonDto person) {
        final String firstName = person.firstName.toUpperCase()
        final String lastName = person.lastName.toLowerCase()
        final PersonDto transformedPerson = new PersonDto(personId: seq.incrementAndGet(), firstName: firstName, lastName: lastName)

        log.info("converting (${person}) into (${transformedPerson})")
        return transformedPerson
    }

}
