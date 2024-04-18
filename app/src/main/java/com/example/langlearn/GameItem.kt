package com.example.langlearn

data class GameItem(
    val word: String,
    var isOpponentAnswer: Boolean = false,
    var isSelected: Boolean = false,
    var isWrong: Boolean = false,
    var isCorrect: Boolean = false
)