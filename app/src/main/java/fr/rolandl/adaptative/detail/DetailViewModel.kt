package fr.rolandl.adaptative.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.rolandl.adaptative.bo.Product
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
  
  private val id = savedStateHandle.get<Int>("id") ?: 0
  
  val product = MutableStateFlow<Product?>(null)
  
  init {
    loadData()
  }
  
  private fun loadData() {
    if (id == 0) {
      throw IllegalArgumentException("Id cannot be 0")
    }
    
    product.value = Product(id, "fake name")
  }
}