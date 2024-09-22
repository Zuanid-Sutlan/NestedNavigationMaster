package com.devstudio.nestednavigationmaster.presentation.navigation.screens

import kotlinx.serialization.Serializable

sealed class ProfileScreens {

    @Serializable
    data object ProfileScreenOne : ProfileScreens()

    @Serializable
    data object ProfileScreenTwo : ProfileScreens()

    @Serializable
    data object ProfileScreenThree : ProfileScreens()

    @Serializable
    data object ProfileScreenFour : ProfileScreens()

}