package io.github.ufukhalis.example.config

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator


@Configuration
@EnableR2dbcRepositories
class DbConfig: AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactoryBuilder
            .withUrl("r2dbc:h2:mem:///db;DB_CLOSE_DELAY=-1")
            .username("sa")
            .build()
    }

    @Bean
    fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)
        initializer.setDatabasePopulator(
            ResourceDatabasePopulator(
                ClassPathResource("schema.sql")
            )
        )
        return initializer
    }
}
