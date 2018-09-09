package com.emre.bootifulkotlin.controller

import com.emre.bootifulkotlin.model.dto.UserDto
import com.emre.bootifulkotlin.model.entity.User
import com.emre.bootifulkotlin.service.UserService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping(value = ["/users"])
@RestController
class HomeController(private val userService: UserService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun findAll(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.findAll())
    }

    @GetMapping(value = ["/{id}"],produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun findById(@PathVariable id: Long) : ResponseEntity<User>{
        return ResponseEntity.ok(userService.findById(id))
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE], consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun createUser(@RequestBody userDto: UserDto) : ResponseEntity<User> {
        return ResponseEntity.ok(userService.create(userDto))
    }

    @PutMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE], consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun updateUser(@PathVariable id: Long, @RequestBody userDto: UserDto): ResponseEntity<User> {
        return ResponseEntity.ok(userService.update(id,userDto))
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.delete(id)
        return ResponseEntity.ok().build()
    }

}