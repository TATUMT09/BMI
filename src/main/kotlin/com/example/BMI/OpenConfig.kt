package com.example.BMI


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class OpenAiConfig {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://api.openai.com/v1")
            .build()
    }
}

@Bean
fun corsConfigurationSource(): CorsConfigurationSource {

    val configuration = CorsConfiguration()

    configuration.allowedOriginPatterns = listOf("*")
    configuration.allowedMethods = listOf("GET","POST","PUT","DELETE","OPTIONS")
    configuration.allowedHeaders = listOf("*")
    configuration.allowCredentials = true

    val source = UrlBasedCorsConfigurationSource()
    source.registerCorsConfiguration("/**", configuration)

    return source
}