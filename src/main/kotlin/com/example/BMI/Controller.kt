package com.example.BMI

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rooms")
class RoomController(
    private val roomService: RoomService
) {

    @PostMapping
    fun create(@RequestBody room: Room): Room {
        return roomService.create(room)
    }

    @GetMapping
    fun getAll(): List<Room> {
        return roomService.getAll()
    }

    @GetMapping("/available")
    fun getAvailable(): List<Room> {
        return roomService.getAvailable()
    }
}

@RestController
@RequestMapping("/api/services")
class HotelServiceController(
    private val hotelServiceService: HotelServiceService
) {

    @PostMapping
    fun create(@RequestBody service: HotelService): HotelService {
        return hotelServiceService.create(service)
    }

    @GetMapping
    fun getAll(): List<HotelService> {
        return hotelServiceService.getAll()
    }
}

@RestController
class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "BMI Hotel Chatbot Backend ishlayapti 🚀"
    }
}
@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
class ChatController(
    private val chatService: ChatService
) {

    @PostMapping
    fun chat(@RequestBody request: ChatRequest): String {

        return chatService.process(
            request.message,
            request.city,
            request.sessionId
        )
    }
}