package com.emre.bootifulkotlin

import com.emre.bootifulkotlin.model.entity.User
import com.emre.bootifulkotlin.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootifulKotlinApplication(val userRepository: UserRepository): CommandLineRunner{
    override fun run(vararg args: String?) {

        val user1 = User( null,"emre", "emrekarabacak@outlook.com")
        val user2 = User(null, "elif", "elifer@elif.com")

        userRepository.save(user1)
        userRepository.save(user2)

    }

}

fun main(args: Array<String>) {
    runApplication<BootifulKotlinApplication>(*args)
}
