package com.example.lab2.players

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.lab2.players.domain.Player
import com.example.lab2.players.viewmodel.PlayersViewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.fontResource

@Composable
fun PlayersScreen(
    viewModel: PlayersViewModel = hiltViewModel(),
    onPlayerClick: (String) -> Unit,
    onAddPlayerClick:() -> Unit
) {
    val listOfPlayers by remember { viewModel.listOfPlayers }

    Column(modifier = Modifier
        .background(Color.Green)
        .fillMaxHeight()) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End){
            Button(modifier = Modifier
                .padding(10.dp)
                .height(60.dp),
                onClick = {
                    onAddPlayerClick()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CircleShape
            ) {
                Text("Add Player"
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
            ,
            elevation = 8.dp,
            backgroundColor = White
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Nume jucator",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .height(50.dp)
                        .width(175.dp)
                )
                Text(
                    text = "Gradul jucatorului",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .height(50.dp)
                        .width(190.dp)
                )
            }
        }

        LazyColumn {
            items(listOfPlayers) { item ->
                SinglePlayerItem(
                    player = item,
                    onPlayerClick = onPlayerClick
                )
            }
        }
    }


}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SinglePlayerItem(
    player: Player,
    onPlayerClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { // handling onMovieClick
                onPlayerClick(player.username)
            }
            ,
        elevation = 8.dp,
        backgroundColor = White
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = player.username,
                fontSize = 24.sp,
                modifier = Modifier
                    .height(50.dp)
                    .width(175.dp)
            )
            Text(
                text = player.grad,
                fontSize = 24.sp,
                modifier = Modifier
                    .height(50.dp)
            )
        }
    }
}