package com.example.lab2.players.usecase

import com.example.lab2.players.domain.Player
import com.example.lab2.players.repo.PlayersRepository
import javax.inject.Inject

interface GetPlayersUseCase {
    suspend operator fun invoke(): List<Player>
}

class GetPlayersUseCaseImpl @Inject constructor(
    val repo: PlayersRepository
) : GetPlayersUseCase {
    override suspend fun invoke(): List<Player> {
        return repo.getAllPlayers()
    }
}