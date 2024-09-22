package com.devstudio.nestednavigationmaster.presentation.navigation.screens

import kotlinx.serialization.Serializable

sealed class UpdateScreens {
    @Serializable
    data object UpdateScreenOne : UpdateScreens()

//    @Serializable
//    data object UpdateScreenTwo : UpdateScreens()
//
//    @Serializable
//    data object UpdateScreenThree : UpdateScreens()
//
//    @Serializable
//    data object UpdateScreenFour : UpdateScreens()

}