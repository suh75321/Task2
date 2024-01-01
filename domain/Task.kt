package com.teamsparta.courseregistration2.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Task (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String = "",
    var content: String = "",
    var writer: String = "",
    var createdAt: LocalDateTime = LocalDateTime.now()
)


