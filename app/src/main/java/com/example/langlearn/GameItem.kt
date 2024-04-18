package com.example.langlearn

data class GameItem(
    val word: String,
    val user: String = "",
    var isSelected: Boolean = false,
    var isWrong: Boolean = false,
    var isCorrect: Boolean = false
)