package fr.rolandl.adaptative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.ThreePaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import fr.rolandl.adaptative.detail.DetailScreen
import fr.rolandl.adaptative.detailplaceholder.DetailPlaceHolderScreen
import fr.rolandl.adaptative.list.ListScreen
import fr.rolandl.adaptative.ui.theme.POCAdaptativeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3AdaptiveApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    enableEdgeToEdge()
    
    setContent {
      val navigator = rememberListDetailPaneScaffoldNavigator<Int>()
      
      BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
      }
      
      POCAdaptativeTheme {
        PoCNavigator(
          navigator = navigator
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun PoCNavigator(
  navigator: ThreePaneScaffoldNavigator<Int>
) {
  ListDetailPaneScaffold(
    directive = navigator.scaffoldDirective,
    value = navigator.scaffoldValue,
    listPane = {
      AnimatedPane {
        ListScreen(
          onProductClicked = {
            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, it)
          }
        )
      }
    },
    detailPane = {
      AnimatedPane {
        val productId = navigator.currentDestination?.content
        
        if (productId == null) {
          DetailPlaceHolderScreen()
        } else {
          DetailScreen(productId)
        }
      }
    }
  )
}