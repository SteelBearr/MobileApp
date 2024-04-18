package com.example.langlearn

data class GameTask (
    val word: String,
    val pronunciation: String,
    val user: String,
    val variants: List<String>,
    val correct: String
)