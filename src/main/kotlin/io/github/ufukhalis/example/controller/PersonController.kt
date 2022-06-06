package io.github.ufukhalis.example.controller

import io.github.ufukhalis.example.model.Person
import io.github.ufukhalis.example.service.PersonService
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/person")
class PersonController(
    private val personService: PersonService
) {

    @PostMapping("/")
    suspend fun createPerson(@RequestBody person: Person): Person {
        return personService.createPerson(person)
    }

    @FlowPreview
    @GetMapping("/")
    suspend fun getAllPersons(): Flow<Person> {
        return personService.getAllPersons()
    }
}
