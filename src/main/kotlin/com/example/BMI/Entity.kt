package com.example.BMI

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Table
import java.time.LocalDateTime






@MappedSuperclass
abstract class BaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
@Entity
@Table(name = "rooms")
class Room(

    @Column(nullable = false, unique = true)
    var roomNumber: String,

    @Column(nullable = false)
    var price: Double,

    @Column(nullable = false)
    var capacity: Int,

    @Column(nullable = false)
    var isAvailable: Boolean = true

) : BaseEntity()
@Entity
@Table(name = "hotel_services")
class HotelService(

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String

) : BaseEntity()
@Entity
@Table(name = "chat_logs")
class ChatLog(

    @Column(nullable = false, length = 1000)
    var userMessage: String,

    @Column(nullable = false, length = 2000)
    var botResponse: String,

    @Column(nullable = false)
    var sessionId: String

) : BaseEntity()