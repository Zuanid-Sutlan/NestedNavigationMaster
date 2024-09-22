package com.devstudio.nestednavigationmaster.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devstudio.nestednavigationmaster.presentation.navigation.GraphRoutes
import com.devstudio.nestednavigationmaster.presentation.navigation.screens.UpdateScreens
import com.devstudio.nestednavigationmaster.presentation.screens.updates.UpdateScreen

fun NavGraphBuilder.updateGraph(navController: NavHostController) {

    navigation<GraphRoutes.UpdateGraph>(
        startDestination = UpdateScreens.UpdateScreenOne
    ){

        composable<UpdateScreens.UpdateScreenOne> {
            UpdateScreen()
        }

    }

}