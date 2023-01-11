package com.adesoftware.phantomstore.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adesoftware.phantomstore.model.Product
import com.adesoftware.phantomstore.R
import com.adesoftware.phantomstore.databinding.ItemStoreBinding
import com.squareup.picasso.Picasso

class StoreListAdapter: RecyclerView.Adapter<StoreListAdapter.StoreItemViewHolder>() {

    private val storeItems = arrayListOf<Product>()

    fun onAddProductItem(item: Product) {
        storeItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        return StoreItemViewHolder(
            ItemStoreBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        holder.bind(storeItems[position])
    }

    override fun getItemCount() = storeItems.size

    class StoreItemViewHolder(
        binding: ItemStoreBinding
    ): RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.ivProduct
        private val title = binding.tvTitle
        private val price = binding.tvPrice
        private val category = binding.tvCategory
        private val description = binding.tvDescription

        fun bind(storeItem: Product) {
            Picasso.get()
                .load(storeItem.productImage)
                .placeholder(R.drawable.android)
                .error(R.drawable.android)
                .into(imageView)
            title.text = storeItem.title
            price.text = storeItem.price.toString()
            category.text = storeItem.category
            description.text = storeItem.description
        }
    }
}