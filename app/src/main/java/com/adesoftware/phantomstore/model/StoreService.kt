package com.adesoftware.phantomstore.model

import retrofit2.http.GET

interface StoreService {
    @GET(Constants.END_POINTS)
    suspend fun getProducts(): List<Product>
}