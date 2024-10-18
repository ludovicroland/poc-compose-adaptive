package fr.rolandl.adaptative.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailScreen(
  productId: Int,
  modifier: Modifier = Modifier,
) {
  val viewModel = hiltViewModel<DetailViewModel, DetailViewModel.Factory>(
    key = productId.toString(),
    creationCallback = {
      it.create(productId)
    }
  )
  
  val product by viewModel.product.collectAsStateWithLifecycle()
  
  Text(
    text = product?.toString() ?: "",
    style = MaterialTheme.typography.bodyMedium
  )
}