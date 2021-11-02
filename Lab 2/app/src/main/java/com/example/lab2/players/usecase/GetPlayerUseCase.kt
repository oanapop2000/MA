package com.example.lab2.players.usecase

import com.example.lab2.players.domain.Player
import com.example.lab2.players.repo.PlayersRepository
import javax.inject.Inject

interface GetPlayerUseCase {
    suspend operator fun invoke(username: String): Player
}

class GetPlayerUseCaseImpl @Inject constructor(
    val repo: PlayersRepository
) : GetPlayerUseCase {
    override suspend fun invoke(username: String): Player {
        return repo.getPlayer(username)
    }
}