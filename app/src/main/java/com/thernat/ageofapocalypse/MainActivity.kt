package com.thernat.ageofapocalypse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.thernat.ageofapocalypse.detail.ComicDetailsScreen
import com.thernat.ageofapocalypse.detail.detailScreenId
import com.thernat.ageofapocalypse.home.HomeScreen
import com.thernat.ageofapocalypse.home.homeScreenId
import com.thernat.ageofapocalypse.ui.theme.AgeOfApocalypseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgeOfApocalypseTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = homeScreenId) {
                    composable(homeScreenId) {
                        HomeScreen(navController)
                    }
                    composable("$detailScreenId/{comicId}",
                        arguments = listOf(navArgument("comicId"){
                            type = NavType.IntType
                        })) {navBackStackEntry ->
                        ComicDetailsScreen(navBackStackEntry.arguments?.getInt("comicId"),
                            navController
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}