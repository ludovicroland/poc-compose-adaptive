package fr.rolandl.adaptative.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
  val route: String,
  val navArguments: List<NamedNavArgument> = emptyList()
) {
  
  data object DetailPlaceHolder : Screen(
    route = "detailplaceholder"
  )
  
  data object Detail : Screen(
    route = "detail/{id}",
    navArguments = listOf(navArgument("id") {
      type = NavType.IntType
    })
  ) {
    fun createRoute(id: Int) =
      "detail/$id"
  }
  
}