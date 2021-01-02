package com.example.carrotmarket.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.dataclass.User
import com.example.carrotmarket.databinding.ItemProductBinding
import com.example.carrotmarket.dataclass.Product

class ProductRecyclerAdapter: RecyclerView.Adapter<ProductViewHolder>(){
    //var list = mutableListOf<Product>()
    var list = listOf<Product>(
        Product(
            1,
            "title1",
            User(
                2,
                "userName",
                "town",
                "email",
                "01098869322",
                null,
                null
            ),
            12000,
            "description",
            true
        ),
        Product(
            2,
            "title2",
            User(
                2,
                "userName2",
                "town",
                "email",
                "01098869322",
                null,
                null
            ),
            12300,
            "description1",
            true
        )
    )

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