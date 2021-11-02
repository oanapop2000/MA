package com.example.lab2.players.repo

import com.example.lab2.players.domain.Player
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import javax.inject.Inject

interface PlayersRepository {
    suspend fun getAllPlayers(): List<Player>
    suspend fun getPlayer(username: String) : Player
    suspend fun addPlayer(id: String, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: String) : String
    suspend fun modifyPlayer(id: Int, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: Int) : String
    suspend fun deletePlayer(id: Int)
}

class PlayersRepositoryImpl @Inject constructor(
) : PlayersRepository {

    val listOfPlayers: ArrayList<Player> = arrayListOf(
        Player( 1, "a", "b", "b@gmail.com", "12-12-2000", "Incepator", 5),
        Player( 2, "b", "c", "c@gmail.com", "12-11-2000", "Incepator", 8)
    )

    override suspend fun getAllPlayers(): List<Player> {
        return listOfPlayers
    }

    override suspend fun getPlayer(username: String): Player{
        for (player: Player in listOfPlayers){
            if (player.username.equals(username)){
                return player
            }
        }
        return Player( 0, "", "", "", "", "", 0)
    }

    fun validareInt(nr: String): Int{
        var ok =  1
        try {
            parseInt(nr)
        }catch (e: java.lang.NumberFormatException){
            ok = 0
        }
        return ok
    }

    override suspend fun addPlayer(id: String, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: String): String{
        var message = "Ok"
        if(username.equals("")){
            message = "Campul pt username e gol!"
        }
        else if(nume.equals("")){
            message = "Campul pt nume e gol!"
        }
        else if(email.equals("")){
            message = "Campul pt email e gol!"
        }
        else{
            try {
                val idBun = parseInt(id)
                try {
                    val nrMeciuriBun = parseInt(nrMeciuri)
                    val list = data.split("-")
                    if(list[0].length==2 && list[1].length == 2 && list[2].length == 4 && validareInt(list[0]) == 1 && validareInt(list[1]) == 1 && validareInt(list[2]) == 1){
                        if( grad.equals("Incepator") || grad.equals("Mediu") || grad.equals("Avansat")){
                            for(player: Player in listOfPlayers){
                                if(player.id.equals(idBun)){
                                    message = "Id-ul trebuie sa fie unic"
                                }
                                else if(player.username.equals(username)){
                                    message = "Username-ul trebuie sa fie unic!"
                                }
                            }
                            if(message == "Ok"){
                                if(idBun < 0){
                                    message = "Id ul trebuie sa fie pozitiv!"
                                }
                                else{
                                    if(nrMeciuriBun < 0){
                                        message = "Nr meciurilor trebuie sa fie pozitiv!"
                                    }
                                    else{
                                        val player = Player(idBun, username, nume, email, data, grad, nrMeciuriBun)
                                        listOfPlayers.add(player)
                                    }
                                }

                            }
                        }else{
                            message = "Gradul trebuie sa fie Incepator, Mediu sau Avansat"
                        }

                    }else{
                        message = "Data nu este in formatul cerut!"
                    }
                }catch (e: NumberFormatException){
                    message = "Numarul meciurilor nu e numeric!"
                }
            } catch (e: NumberFormatException) {
                message = "Id-ul nu e numeric!"
            }
        }
        return message
    }

    override suspend fun modifyPlayer(id: Int, username: String, nume: String, email: String, data: String, grad: String, nrMeciuri: Int): String{
        var message = "Ok"
        if(nume.equals("")){
            message = "Campul pt nume e gol!"
        }
        else if(email.equals("")){
            message = "Campul pt email e gol!"
        }
        else{
            val list = data.split("-")
            if(list[0].length==2 && list[1].length == 2 && list[2].length == 4 && validareInt(list[0]) == 1 && validareInt(list[1]) == 1 && validareInt(list[2]) == 1){
                if( grad.equals("Incepator") || grad.equals("Mediu") || grad.equals("Avansat")){
                    if(message == "Ok"){
                        if(nrMeciuri < 0){
                            message = "Nr meciurilor trebuie sa fie pozitiv!"
                        }
                        else{
                            for(player: Player in listOfPlayers){
                                if(player.id.equals(id)){
                                    player.email = email
                                    player.nume = nume
                                    player.dataNasterii = data
                                    player.grad = grad
                                    player.nrMeciuriCastigate = nrMeciuri
                                }
                            }
                        }

                    }
                }else{
                    message = "Gradul trebuie sa fie Incepator, Mediu sau Avansat"
                }

            }else{
                message = "Data nu este in formatul cerut!"
            }
        }
        return message
    }

    override suspend fun deletePlayer(id: Int){
        var i = 0
        for (player: Player in listOfPlayers){
            if (player.id == id){
                listOfPlayers.removeAt(i)
                break
            }
            i++
        }
    }
}