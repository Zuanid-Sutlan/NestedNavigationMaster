package com.devstudio.nestednavigationmaster.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devstudio.nestednavigationmaster.presentation.navigation.GraphRoutes
import com.devstudio.nestednavigationmaster.presentation.navigation.screens.HomeScreens
import com.devstudio.nestednavigationmaster.presentation.screens.home.HomeScreenFour
import com.devstudio.nestednavigationmaster.presentation.screens.home.HomeScreenOne
import com.devstudio.nestednavigationmaster.presentation.screens.home.HomeScreenThree
import com.devstudio.nestednavigationmaster.presentation.screens.home.HomeScreenTwo

fun NavGraphBuilder.homeGraph(navController: NavHostController){

    navigation<GraphRoutes.HomeGraph>(
        startDestination = HomeScreens.HomeScreenOne
    ){
        composable<HomeScreens.HomeScreenOne> {
            HomeScreenOne(
                navigateToScreen2 = {
                    navController.navigate(HomeScreens.HomeScreenTwo)
                }
            )
        }

        composable<HomeScreens.HomeScreenTwo> {
            HomeScreenTwo(
                navigateToScreen3 = {
                    navController.navigate(HomeScreens.HomeScreenThree)
                },
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

        composable<HomeScreens.HomeScreenThree> {
            HomeScreenThree(
                navigateToScreenFour = {
                    navController.navigate(HomeScreens.HomeScreenFour)
                },
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

        composable<HomeScreens.HomeScreenFour> {
            HomeScreenFour(
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

    }
}