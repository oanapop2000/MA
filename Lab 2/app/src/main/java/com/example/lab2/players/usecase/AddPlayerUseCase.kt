package com.example.lab2.players.usecase

import com.example.lab2.players.domain.Player
import com.example.lab2.players.repo.PlayersRepository
import javax.inject.Inject


interface AddPlayerUseCase {
    suspend operator fun invoke(id: String, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: String): String
}

class AddPlayerUseCaseImpl @Inject constructor(
    val repo: PlayersRepository
) : AddPlayerUseCase {
    override suspend fun invoke(id: String, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: String): String {
        return repo.addPlayer(id, username, nume, email, data, grad, nrMeciuri)
    }
}