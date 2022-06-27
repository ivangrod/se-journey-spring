package org.ivangrod.domainevents

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class DomainEventsApplication

fun main(args: Array<String>) {
    runApplication<DomainEventsApplication>(*args)
}
