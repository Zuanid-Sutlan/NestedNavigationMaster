package com.devstudio.nestednavigationmaster.presentation.navigation.screens

import kotlinx.serialization.Serializable

sealed class HomeScreens {

    @Serializable
    data object HomeScreenOne : HomeScreens()

    @Serializable
    data object HomeScreenTwo : HomeScreens()

    @Serializable
    data object HomeScreenThree : HomeScreens()

    @Serializable
    data object HomeScreenFour : HomeScreens()

}