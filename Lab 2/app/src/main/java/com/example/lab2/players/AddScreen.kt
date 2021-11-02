package com.example.lab2.players

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
fun AddScreen(viewModel: PlayersViewModel = hiltViewModel(),
              onAddClick:() -> Unit) {

    val id = remember { mutableStateOf(TextFieldValue()) }
    val username = remember { mutableStateOf(TextFieldValue()) }
    val nume = remember { mutableStateOf(TextFieldValue()) }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val data = remember { mutableStateOf(TextFieldValue()) }
    val grad = remember { mutableStateOf(TextFieldValue()) }
    val nrMeciuri = remember { mutableStateOf(TextFieldValue()) }

    val openDialog = remember { mutableStateOf(false) }

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

    Column(modifier = Modifier.background(color = Color.Green).fillMaxHeight()) {
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
                    value = id.value,
                    onValueChange = { id.value = it },
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
                    onValueChange = { username.value = it },
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
                verticalAlignment = Alignment.CenterVertically,
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
                    label = { Text("DD-MM-YYYY") },
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
                    value = nrMeciuri.value,
                    onValueChange = { nrMeciuri.value = it },
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
                    viewModel.addPlayer(
                        id.value.text,
                        username.value.text,
                        nume.value.text,
                        email.value.text,
                        data.value.text,
                        grad.value.text,
                        nrMeciuri.value.text
                    )
                    if (viewModel.message.value.equals("Ok")) {
                        onAddClick()
                    } else {
                        openDialog.value = true
                    }
                }
            ) {
                Text(
                    "Add"
                )
            }

        }
    }
}

