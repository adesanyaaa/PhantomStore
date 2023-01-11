package com.adesoftware.phantomstore.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adesoftware.phantomstore.databinding.ActivityStoreBinding
import com.adesoftware.phantomstore.model.adapter.StoreListAdapter
import com.adesoftware.phantomstore.viewmodel.StoreListViewModel

class StoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoreBinding
    lateinit var viewModel: StoreListViewModel
    private val storeListAdapter = StoreListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(StoreListViewModel::class.java)

        binding.rvStoreListings.apply {
            layoutManager = LinearLayoutManager(this@StoreActivity)
            adapter = storeListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.storeProducts.observe(this, Observer { product ->
            binding.loadingView.visibility = View.GONE
            binding.rvStoreListings.visibility = View.VISIBLE
            storeListAdapter.onAddProductItem(product)
            binding.rvStoreListings.scrollToPosition(0)
        })
    }
}