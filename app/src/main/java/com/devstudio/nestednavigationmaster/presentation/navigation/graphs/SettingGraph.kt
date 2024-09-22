package com.devstudio.nestednavigationmaster.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devstudio.nestednavigationmaster.presentation.navigation.GraphRoutes
import com.devstudio.nestednavigationmaster.presentation.navigation.screens.ProfileScreens
import com.devstudio.nestednavigationmaster.presentation.navigation.screens.SettingScreens
import com.devstudio.nestednavigationmaster.presentation.screens.settings.SettingScreenFour
import com.devstudio.nestednavigationmaster.presentation.screens.settings.SettingScreenOne
import com.devstudio.nestednavigationmaster.presentation.screens.settings.SettingScreenThree
import com.devstudio.nestednavigationmaster.presentation.screens.settings.SettingScreenTwo

fun NavGraphBuilder.settingGraph(navController: NavHostController) {

    navigation<GraphRoutes.SettingGraph>(
        startDestination = SettingScreens.SettingScreenOne
    ){

        composable<SettingScreens.SettingScreenOne> {
            SettingScreenOne(
                navigateToScreen2 = {
                    navController.navigate(SettingScreens.SettingScreenTwo)
                }
            )
        }

        composable<SettingScreens.SettingScreenTwo> {
            SettingScreenTwo(
                navigateToScreen3 = {
                    navController.navigate(SettingScreens.SettingScreenThree)
                },
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

        composable<SettingScreens.SettingScreenThree> {
            SettingScreenThree(
                navigateToScreen4 = {
                    navController.navigate(SettingScreens.SettingScreenFour)
                },
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

        composable<SettingScreens.SettingScreenFour> {
            SettingScreenFour(
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

    }

}