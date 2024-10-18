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
  modifier: Modifier = Modifier,
  viewModel: DetailViewModel = hiltViewModel()
) {
  val product by viewModel.product.collectAsStateWithLifecycle()
  
  Text(
    text = product?.toString() ?: "",
    style = MaterialTheme.typography.bodyMedium
  )
}