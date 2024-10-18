package fr.rolandl.adaptative.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.rolandl.adaptative.bo.Product

@Composable
fun DetailScreenWithProduct(
  modifier: Modifier = Modifier,
  product: Product
) {
  Text(
    text = product.toString(),
    style = MaterialTheme.typography.bodyMedium
  )
}