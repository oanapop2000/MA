package com.example.lab2.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lab2.players.viewmodel.PlayersViewModel

@Composable
fun PlayerDetailsScreen(viewModel: PlayersViewModel = hiltViewModel(),
                        selectedPlayer: String,
                        onModifyClick:() -> Unit,
onDeleteClick:() -> Unit) {
    viewModel.getPlayer(selectedPlayer)
    val player by remember { viewModel.player }
    val id = remember { mutableStateOf(player.id) }
    val username = remember { mutableStateOf(player.username) }
    val nume = remember { mutableStateOf(player.nume) }
    val email = remember { mutableStateOf(player.email) }
    val data = remember { mutableStateOf(player.dataNasterii) }
    val grad = remember { mutableStateOf(player.grad) }
    val nrMeciuri = remember { mutableStateOf(player.nrMeciuriCastigate) }

    val openDialog = remember { mutableStateOf(false) }
    val openDialogDelete = remember {
        mutableStateOf(false)
    }


    if (openDialogDelete.value) {

        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                openDialogDelete.value = false
            },
            title = {
                Text(text = "Info")
            },
            text = {
                Text("Jucatorul a fost sters cu succes!")
            },
            confirmButton = {
                Button(

                    onClick = {
                        openDialogDelete.value = false
                        onDeleteClick()
                    }) {
                    Text("Ok")
                }
            }
        )
    }

    if (openDialog.value) {

        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                openDialog.value = false
            },
            title = {
                Text(text = "Error")
            },
            text = {
                Text(viewModel.message.value)
            },
            confirmButton = {
                Button(

                    onClick = {
                        openDialog.value = false
                    }) {
                    Text("Ok")
                }
            }
        )
    }

    Column(modifier = Modifier.background(Color.Green).fillMaxHeight()) {
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Id: ",
                    fontSize = 24.sp
                )

                TextField(
                    value = id.value.toString(),
                    onValueChange = { },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Username: ",
                    fontSize = 24.sp
                )
                TextField(
                    value = username.value,
                    onValueChange = { },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nume: ",
                    fontSize = 24.sp
                )
                TextField(
                    value = nume.value,
                    onValueChange = { nume.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Email: ",
                    fontSize = 24.sp
                )
                TextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Data nasterii: ",
                    fontSize = 24.sp
                )
                TextField(
                    value = data.value,
                    onValueChange = { data.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    label = { Text("DD-MM-YY") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {

            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Grad: ",
                    fontSize = 24.sp
                )
                TextField(
                    value = grad.value,
                    onValueChange = { grad.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nr meciuri castigate: ",
                    fontSize = 24.sp
                )
                TextField(
                    value = nrMeciuri.value.toString(),
                    onValueChange = { nrMeciuri.value = Integer.parseInt(it) },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(modifier = Modifier
                .padding(25.dp)
                .height(100.dp)
                .width(120.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                onClick = {
                    viewModel.modifyPlayer(
                        id.value,
                        username.value,
                        nume.value,
                        email.value,
                        data.value,
                        grad.value,
                        nrMeciuri.value
                    )
                    if (viewModel.message.value.equals("Ok")) {
                        onModifyClick()
                    } else {
                        openDialog.value = true
                    }
                }
            ) {
                Text(
                    "Modify"
                )
            }
            Button(modifier = Modifier
                .padding(25.dp)
                .height(100.dp)
                .width(120.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                onClick = {
                    viewModel.deletePlayer(
                        id.value
                    )
                    openDialogDelete.value = true

                }
            ) {
                Text(
                    "Delete"
                )
            }
        }
    }
}

