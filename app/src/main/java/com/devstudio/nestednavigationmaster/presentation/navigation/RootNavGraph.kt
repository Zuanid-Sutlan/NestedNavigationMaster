package com.devstudio.nestednavigationmaster.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.RootGroupName
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devstudio.nestednavigationmaster.presentation.navigation.graphs.homeGraph
import com.devstudio.nestednavigationmaster.presentation.navigation.graphs.profileGraph
import com.devstudio.nestednavigationmaster.presentation.navigation.graphs.settingGraph
import com.devstudio.nestednavigationmaster.presentation.navigation.graphs.updateGraph
import kotlinx.serialization.Serializable

@Composable
fun SetupRootNavGraph(modifier: Modifier = Modifier, navController: NavHostController){



    NavHost(modifier = modifier, navController = navController, startDestination = GraphRoutes.HomeGraph){

//        composable<GraphRoutes.HomeGraph> {
            homeGraph(navController = navController)
//        }

//        composable<GraphRoutes.ProfileGraph> {
            profileGraph(navController = navController)
//        }

//        composable<GraphRoutes.SettingGraph> {
            settingGraph(navController = navController)
//        }

//        composable<GraphRoutes.UpdateGraph> {
            updateGraph(navController = navController)
//        }

    }

}


sealed class GraphRoutes{

    @Serializable
    data object RootGraph: GraphRoutes()

    @Serializable
    data object HomeGraph : GraphRoutes()

    @Serializable
    data object ProfileGraph : GraphRoutes()

    @Serializable
    data object SettingGraph : GraphRoutes()

    @Serializable
    data object UpdateGraph : GraphRoutes()


}