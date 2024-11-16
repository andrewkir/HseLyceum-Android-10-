package ru.andrewkir.saturday10.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.andrewkir.saturday10.R
import ru.andrewkir.saturday10.data.models.GoodsItemModel
import ru.andrewkir.saturday10.presentation.contract.GoodsEvent
import ru.andrewkir.saturday10.presentation.contract.GoodsEvent.AddButtonClicked
import ru.andrewkir.saturday10.presentation.contract.GoodsEvent.UpdateGoodsTextField
import ru.andrewkir.saturday10.presentation.contract.GoodsEvent.UpdateGoodsUrlField
import ru.andrewkir.saturday10.presentation.contract.GoodsState
import kotlin.random.Random

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is UpdateGoodsTextField -> {
        state.value = state.value.copy(goodsName = event.text)
      }

      AddButtonClicked -> {
        state.value = state.value.copy(
          goods = state.value.goods + listOf(
            GoodsItemModel(
              name = state.value.goodsName,
              price = Random.nextInt() % 5,
              stars = Random.nextInt() % 1000,
              imageId = R.drawable.ershik,
              imageURL = state.value.goodsUrl,
            )
          ),
          goodsName = "",
          goodsUrl = "",
        )
      }

      is UpdateGoodsUrlField -> {
        state.value = state.value.copy(goodsUrl = event.url)
      }
    }
  }

  // if(isNumeric(event.text)) {
  //  state.value = ...
  // }

  fun isNumeric(toCheck: String): Boolean {
    return toCheck.all { char -> char.isDigit() }
  }
}