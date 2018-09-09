package com.emre.bootifulkotlin.service

import com.emre.bootifulkotlin.exception.UserNotFoundException
import com.emre.bootifulkotlin.model.dto.UserDto
import com.emre.bootifulkotlin.model.entity.User
import com.emre.bootifulkotlin.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {


    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findById(id: Long): User {
        return userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
    }

    fun create(userDto: UserDto): User {
        val userEntity = User(null, userDto.username, userDto.email)
        return userRepository.save(userEntity)
    }

    fun update(id: Long, userDto: UserDto) : User {
        val user = findById(id)
        val updatedUserEntity = user.copy(username = userDto.username, email = userDto.email)
        return userRepository.save(updatedUserEntity)
    }

    fun delete(id: Long) {
        findById(id)
        userRepository.deleteById(id)
    }
}