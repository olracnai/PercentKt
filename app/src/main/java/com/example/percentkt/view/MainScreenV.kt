package com.example.percentkt.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.percentkt.engine_logic.PercentFunctions
import com.example.percentkt.engine_logic.PercentKtViewModel

// Portrait view
@Preview(showBackground = true)
@Composable
fun MainScreenV() {
    val viewModel: PercentKtViewModel = viewModel()
    val amountValue = viewModel.amount.text.toFloatOrNull() ?: 0f
    val percentValue = viewModel.percent.text.toIntOrNull() ?: 0
    val percentageCalculator = PercentFunctions(amount = amountValue, percent = percentValue)

// Container
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

// Title container
        Row(modifier = Modifier
            .fillMaxSize()
            .weight(2f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Percent Kt", fontSize = 24.sp)
        }
// Result + Divider + Input -> Container
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(5f)) {
// Results container
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(6f)
                .padding(horizontal = 50.dp)) {

                Row(modifier = Modifier
                    .fillMaxSize()
                    .shadow(elevation = 2.dp, spotColor = MaterialTheme.colorScheme.secondary)
                    .weight(2f),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Base + Result = ${percentageCalculator.basePlusPercentage}", modifier = Modifier.padding(start = 15.dp))
                }
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                )
                Row(modifier = Modifier
                    .fillMaxSize()
                    .shadow(elevation = 2.dp, spotColor = MaterialTheme.colorScheme.secondary)
                    .weight(2f),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Percentage Result = ${percentageCalculator.percentageOfBase}", modifier = Modifier.padding(start = 15.dp))
                }
            }
// Divider container
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(2f)
                .padding(horizontal = 20.dp)) {

                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .weight(0.7f)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .height(1.dp), color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f)
                )
            }
// Inputs container
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(6f)
                .padding(horizontal = 20.dp)) {

                OutlinedTextField(
                    value = viewModel.percent,
                    onValueChange = { viewModel.percent = it },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(4f),
                    textStyle = LocalTextStyle.current,
                    singleLine = true,
                    label = { Text("Enter %") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                )
                OutlinedTextField(
                    value = viewModel.amount,
                    onValueChange = { viewModel.amount = it },
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxSize()
                        .weight(4f),
                    textStyle = LocalTextStyle.current,
                    singleLine = true,
                    label = { Text("Enter base amount") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                )
            }
        }
// Clear button container
        Column(modifier = Modifier
            .fillMaxSize()
            .weight(4f)
            .padding(horizontal = 100.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.fillMaxSize().weight(2f))
            Button(modifier = Modifier.fillMaxSize().weight(2f).background(color = MaterialTheme.colorScheme.primary),
                onClick = {
                    viewModel.amount = TextFieldValue("")
                    viewModel.percent = TextFieldValue("") }) {
                Text(text = "Clear")
            }
            Spacer(modifier = Modifier.fillMaxSize().weight(5f))
        }
    }
}
