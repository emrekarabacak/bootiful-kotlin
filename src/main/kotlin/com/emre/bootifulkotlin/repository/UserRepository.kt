package com.emre.bootifulkotlin.repository

import com.emre.bootifulkotlin.model.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>