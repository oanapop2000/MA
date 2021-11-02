package com.example.lab2.players.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.players.domain.Player
import com.example.lab2.players.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    useCase: GetPlayersUseCase,
    val getPlayerUseCase: GetPlayerUseCase,
    val addPlayerUseCase: AddPlayerUseCase,
    val modifyPlayerUseCase: ModifyPlayerUseCase,
    val deletePlayerUseCase: DeletePlayerUseCase
) : ViewModel() {

    private val _listOfPlayers: MutableState<List<Player>> = mutableStateOf(emptyList())
    private val _player: MutableState<Player> = mutableStateOf(Player( 0, "", "", "", "", "", 0))
    private val _message: MutableState<String> = mutableStateOf("")
    val listOfPlayers: State<List<Player>> = _listOfPlayers
    val player: State<Player> = _player
    val message: State<String> = _message

    init {
        viewModelScope.launch {
            val playerList = useCase()
            _listOfPlayers.value = playerList
        }
    }

    fun getPlayer(username: String){
        viewModelScope.launch {
            val playerFound = getPlayerUseCase(username)
            _player.value = playerFound
        }
    }

    fun addPlayer(id: String, username: String, nume:String, email:String, data:String, grad:String, nrMeciuri: String){
        viewModelScope.launch {
            val message = addPlayerUseCase(id, username, nume, email, data, grad, nrMeciuri)
            _message.value = message
        }
    }

    fun modifyPlayer(id: Int, username: String, nume:String, email:String, data:String, grad:String, nrMeciuri: Int){
        viewModelScope.launch {
            val message = modifyPlayerUseCase(id, username, nume, email, data, grad, nrMeciuri)
            _message.value = message
        }
    }

    fun deletePlayer(id: Int){
        viewModelScope.launch {
            deletePlayerUseCase(id)
        }
    }
}