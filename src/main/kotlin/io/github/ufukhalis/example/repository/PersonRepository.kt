package io.github.ufukhalis.example.repository

import io.github.ufukhalis.example.model.Person
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository


@Repository
class PersonRepository(private val client: DatabaseClient) {

    suspend fun addPerson(person: Person): Void? {
        return client.sql {
            "INSERT INTO PERSON (full_name, age) VALUES($1, $2)"
        }.bind(0, person.fullName)
         .bind(1, person.age)
         .then()
         .awaitFirstOrNull()
    }

    @FlowPreview
    suspend fun getAllPersons(): Flow<Person> {
        return client.sql {
            "SELECT * FROM person"
        }.map { row, _ ->
            Person(
                fullName = row.get("full_name", String::class.java)!!,
                age = row.get("age", Integer::class.java)?.toInt()!!
            )
        }.all()
         .asFlow()
    }

}
