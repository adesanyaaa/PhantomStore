package com.adesoftware.phantomstore.model

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoreRepository {
    private val storeService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StoreService::class.java)

    fun getStoreProducts(): Flow<Product> {
        return flow {
            val productSource = storeService.getProducts()
            productSource.forEach {
                emit(it)
                delay(Constants.PRODUCT_DELAY)
            }
        }
    }
}