package com.adesoftware.phantomstore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adesoftware.phantomstore.model.StoreRepository

class StoreListViewModel: ViewModel() {
    val storeProducts = StoreRepository().getStoreProducts().asLiveData()
}