package com.devstudio.nestednavigationmaster.presentation.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devstudio.nestednavigationmaster.presentation.navigation.GraphRoutes
import com.devstudio.nestednavigationmaster.presentation.navigation.screens.HomeScreens
import com.devstudio.nestednavigationmaster.presentation.navigation.screens.ProfileScreens
import com.devstudio.nestednavigationmaster.presentation.screens.profile.ProfileScreenFour
import com.devstudio.nestednavigationmaster.presentation.screens.profile.ProfileScreenOne
import com.devstudio.nestednavigationmaster.presentation.screens.profile.ProfileScreenThree
import com.devstudio.nestednavigationmaster.presentation.screens.profile.ProfileScreenTwo

fun NavGraphBuilder.profileGraph(navController: NavHostController){

    navigation<GraphRoutes.ProfileGraph>(
        startDestination = ProfileScreens.ProfileScreenOne
    ){

        composable<ProfileScreens.ProfileScreenOne> {
            ProfileScreenOne(
                navigateToScreen2 = {
                    navController.navigate(ProfileScreens.ProfileScreenTwo)
                }
            )
        }

        composable<ProfileScreens.ProfileScreenTwo> {
            ProfileScreenTwo(
                navigateToScreen3 = {
                    navController.navigate(ProfileScreens.ProfileScreenThree)
                },
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

        composable<ProfileScreens.ProfileScreenThree> {
            ProfileScreenThree(
                navigateToScreen4 = {
                    navController.navigate(ProfileScreens.ProfileScreenFour)
                },
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

        composable<ProfileScreens.ProfileScreenFour> {
            ProfileScreenFour(
                popBackStack = {
                    navController.navigateUp()
                }
            )
        }

    }

}