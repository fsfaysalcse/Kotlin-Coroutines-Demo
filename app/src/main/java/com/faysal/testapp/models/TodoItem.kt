package com.faysal.testapp.models

data class TodoItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)