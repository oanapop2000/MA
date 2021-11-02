package com.example.lab2.players.domain

data class Player(
    val id: Int,
    val username: String,
    var nume: String,
    var email: String,
    var dataNasterii: String,
    var grad: String,
    var nrMeciuriCastigate: Int
)