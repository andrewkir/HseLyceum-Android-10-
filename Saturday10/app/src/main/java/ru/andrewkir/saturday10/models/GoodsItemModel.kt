package ru.andrewkir.saturday10.models

import androidx.annotation.DrawableRes

data class GoodsItemModel(
  val name: String,
  val stars: Int,
  val price: Int,
  @DrawableRes
  val imageId: Int,
)
