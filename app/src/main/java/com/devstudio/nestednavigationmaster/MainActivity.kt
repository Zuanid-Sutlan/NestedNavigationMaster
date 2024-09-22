package com.devstudio.nestednavigationmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devstudio.nestednavigationmaster.presentation.navigation.GraphRoutes
import com.devstudio.nestednavigationmaster.presentation.navigation.SetupRootNavGraph
import com.devstudio.nestednavigationmaster.ui.theme.NestedNavigationMasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            val bottomScreenList = listOf(
                BottomScreenModel("Home", Icons.Default.Home, GraphRoutes.HomeGraph),
                BottomScreenModel("Profile", Icons.Default.Person, GraphRoutes.ProfileGraph),
                BottomScreenModel("Setting", Icons.Default.Settings, GraphRoutes.SettingGraph),
                BottomScreenModel("Update", Icons.Default.Build, GraphRoutes.UpdateGraph)
            )

            // Custom list to store routes
            val routeStack = remember { mutableStateListOf<GraphRoutes>(GraphRoutes.HomeGraph) }

            BackHandler(enabled = routeStack.isNotEmpty()) {
                if (routeStack.size > 1) {
                    // Pop the last route and navigate to the previous one
                    routeStack.removeLast()
                    navController.navigate(routeStack.last())
                    {
                        popUpTo(navController.graph.id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
                else {
                   //  Handle exit or default behavior if on the first screen
                    routeStack.clear() // Or handle exit confirmation
                    this.finish()
                }
            }

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination


//            val homeNavController = rememberNavController()
//            val profileNavController = rememberNavController()
//            val settingNavController = rememberNavController()
//            val updateNavController = rememberNavController()
//
//            val navControllers = rememberNavController(
//                rememberNavController(),
//                rememberNavController(),
//                rememberNavController(),
//                rememberNavController(),
//            )
//
//            var selectedScreen by rememberSaveable { mutableIntStateOf(0) }

            NestedNavigationMasterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            bottomScreenList.forEachIndexed { index, bottomScreen ->
                                val isSelected = currentDestination?.hierarchy?.any { it.route == bottomScreen.route::class.qualifiedName } == true
                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
//                                        selectedScreen = index

                                        routeStack.add(bottomScreen.route)

                                        navController.navigate(bottomScreen.route){

                                            popUpTo(navController.graph.id) {
                                                saveState = true
                                            }
                                            restoreState = true

//                                            if (firstTimeOnly.value){
//                                                popUpTo(navController.graph.id){
//                                                    saveState = true
//                                                }
//                                                firstTimeOnly.value = false
//                                            }

//                                            launchSingleTop = true
//                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = bottomScreen.icon,
                                            contentDescription = bottomScreen.name
                                        )
                                    },
                                    label = {
                                        Text(text = bottomScreen.name, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                                    }
                                )

                            }
                        }
                    }
                    ) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {

                        SetupRootNavGraph(navController = navController)

                    }

                }
            }
        }
    }
}

private data class BottomScreenModel(
    val name: String,
    val icon: ImageVector,
    val route: GraphRoutes
)


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NestedNavigationMasterTheme {
        Greeting("Android")
    }
}