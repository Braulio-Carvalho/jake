package com.example.model


import com.example.enum.Gender

import javax.persistence.*


@Entity
@Table(name = "watch")
data class Watch(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var model: String,
    var gender: Gender

)
