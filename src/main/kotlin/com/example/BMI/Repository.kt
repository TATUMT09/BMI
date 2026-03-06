package com.example.BMI


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : JpaRepository<Room, Long> {

    fun findByIsAvailableTrue(): List<Room>

}
interface HotelServiceRepository : JpaRepository<HotelService, Long>

interface ChatLogRepository : JpaRepository<ChatLog, Long> {

    fun findBySessionId(sessionId: String): List<ChatLog>
}