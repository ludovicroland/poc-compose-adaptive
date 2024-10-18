package fr.rolandl.adaptative.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.rolandl.adaptative.bo.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
  
  val items = MutableStateFlow(emptyMap<String, List<Product>>())
  
  init {
    loadData()
  }
  
  private fun loadData() {
    viewModelScope.launch(Dispatchers.IO) {
      items.value = mapOf(
        Pair(
          "T-shirt", listOf(
            Product(1, "T-shirt 1"),
            Product(2, "T-shirt 2"),
            Product(3, "T-shirt 3"),
          )
        ),
        Pair(
          "Short", listOf(
            Product(4, "Short 4"),
            Product(5, "Short 5"),
            Product(6, "Short 6"),
          )
        ),
      )
    }
  }
}