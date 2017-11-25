package com.spring.hr.letsbe.business.test.dto

class PersonDto {
    String personId
    String lastName
    String firstName


    @Override
    String toString() {
        return "PersonDto{" +
                "personId='" + personId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}'
    }
}
