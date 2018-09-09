package com.emre.bootifulkotlin.controller.handler

import com.emre.bootifulkotlin.exception.UserNotFoundException
import com.emre.bootifulkotlin.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*


@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(exception: UserNotFoundException, request: WebRequest): ResponseEntity<ErrorMessage> {

        val errorMessage = ErrorMessage(UUID.randomUUID().toString(), exception.message)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}