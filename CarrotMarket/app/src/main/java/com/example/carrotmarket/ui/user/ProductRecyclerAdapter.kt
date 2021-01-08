package com.example.carrotmarket.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemProductBinding
import com.example.carrotmarket.api.Product

class ProductRecyclerAdapter: RecyclerView.Adapter<ProductViewHolder>(){
    var list = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder{
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

}

class ProductViewHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product){
        binding.titleTextView.text = product.title
        binding.descriptionTextView.text = product.description
        binding.priceTextView.text = product.price.toString() + "원"
    }
}