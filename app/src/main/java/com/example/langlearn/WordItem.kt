package com.example.langlearn

data class WordItem(
    val word: String,
    var isSelected: Boolean = false,
    var isWrong: Boolean = false,
    var isCorrect: Boolean = false
)