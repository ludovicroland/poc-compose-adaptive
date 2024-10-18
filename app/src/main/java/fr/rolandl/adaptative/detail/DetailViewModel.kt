package fr.rolandl.adaptative.detail

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.rolandl.adaptative.bo.Product
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel(assistedFactory = DetailViewModel.Factory::class)
class DetailViewModel @AssistedInject constructor(@Assisted productId: Int) : ViewModel() {
  
  @AssistedFactory
  interface Factory {
    fun create(productId: Int): DetailViewModel
  }
  
  private val id = productId
  
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