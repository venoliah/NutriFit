package com.example.nutrifit

data class NutriChatMessage(
    val messageId: String = "",
    val senderId: String = "",
    val senderName: String = "",
    val message: String = "",
    val timestamp: Long = 0
)
