package fr.rolandl.adaptative.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fr.rolandl.adaptative.bo.Product

@Composable
fun ListScreen(
  modifier: Modifier = Modifier,
  viewModel: ListViewModel = hiltViewModel(),
  onProductClicked: (Product) -> Unit
) {
  val items by viewModel.items.collectAsStateWithLifecycle()
  
  LazyColumn(
    modifier = modifier.fillMaxSize()
  ) {
    items(items.keys.toList()) { key ->
      Text(
        text = key,
        style = MaterialTheme.typography.headlineMedium
      )
      LazyRow(
        modifier = modifier.fillMaxWidth()
      ) {
        items(items[key]!!) { product ->
          Card(
            modifier = Modifier
              .width(100.dp)
              .height(100.dp),
            onClick = {
              onProductClicked(product)
            }
          ) {
            Text(
              text = product.name,
              style = MaterialTheme.typography.headlineMedium
            )
          }
        }
      }
    }
  }
}