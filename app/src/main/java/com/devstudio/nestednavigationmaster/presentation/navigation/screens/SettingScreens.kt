package com.devstudio.nestednavigationmaster.presentation.navigation.screens

import kotlinx.serialization.Serializable

sealed class SettingScreens{

    @Serializable
    data object SettingScreenOne : SettingScreens()

    @Serializable
    data object SettingScreenTwo : SettingScreens()

    @Serializable
    data object SettingScreenThree : SettingScreens()

    @Serializable
    data object SettingScreenFour : SettingScreens()

}