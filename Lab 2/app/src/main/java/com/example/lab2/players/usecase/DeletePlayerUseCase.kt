package com.example.lab2.players.usecase

import com.example.lab2.players.repo.PlayersRepository
import javax.inject.Inject

interface DeletePlayerUseCase {
    suspend operator fun invoke(id: Int)
}

class DeletePlayerUseCaseImpl @Inject constructor(
    val repo: PlayersRepository
) : DeletePlayerUseCase {
    override suspend fun invoke(id: Int) {
        repo.deletePlayer(id)
    }
}