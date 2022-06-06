package io.github.ufukhalis.example.service

import io.github.ufukhalis.example.model.Person
import io.github.ufukhalis.example.repository.PersonRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository
) {

    suspend fun createPerson(person: Person): Person {
        personRepository.addPerson(person)
        return person
    }

    @FlowPreview
    suspend fun getAllPersons(): Flow<Person> {
        return personRepository.getAllPersons()
    }
}
