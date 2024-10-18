package fr.rolandl.adaptative.detailplaceholder

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailPlaceHolderScreen(modifier: Modifier = Modifier)
{
  Text(
    text = "No product selected yet",
    style = MaterialTheme.typography.bodyLarge
  )
}