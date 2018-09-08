package com.emre.bootifulkotlin.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {

    @GetMapping(value = ["/"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun helloWorld(): String {
        return "Hello World"
    }

}