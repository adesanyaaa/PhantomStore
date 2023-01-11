package com.adesoftware.phantomstore.model

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    //val rating: Rating,
    @SerializedName("image")
    val productImage: String
)

data class Rating(
    val count: Int,
    val rate: Double
)