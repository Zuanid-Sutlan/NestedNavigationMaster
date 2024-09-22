package com.devstudio.nestednavigationmaster.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenTwo(modifier: Modifier = Modifier, navigateToScreen3: () -> Unit, popBackStack: () -> Unit) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){


        Column {

            Text(text = "Home Screen Two", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = { navigateToScreen3() }) {
                Text(text = "Navigate to Screen 3")
            }

            Button(onClick = { popBackStack() }) {
                Text(text = "Go back")
            }

        }


    }
}