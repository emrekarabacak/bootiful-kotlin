package com.emre.bootifulkotlin.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(@Id @GeneratedValue val id: Long? = 0, val username: String = "", val email: String = "")