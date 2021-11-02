package com.example.lab2.players.usecase

import com.example.lab2.players.repo.PlayersRepository
import javax.inject.Inject

interface ModifyPlayerUseCase {
    suspend operator fun invoke(id: Int, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: Int): String
}

class ModifyPlayerUseCaseImpl @Inject constructor(
    val repo: PlayersRepository
) : ModifyPlayerUseCase {
    override suspend fun invoke(id: Int, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: Int): String {
        return repo.modifyPlayer(id, username, nume, email, data, grad, nrMeciuri)
    }
}