package com.example.mvvm_room_app.ui.components.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_room_app.R
import com.example.mvvm_room_app.models.`object`.Product

class RecvProduct(var list: List<Product>) : RecyclerView.Adapter<RecvProduct.Data>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecvProduct.Data {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.product_entry, parent, false)
        return Data(layout)
    }

    override fun onBindViewHolder(holder: RecvProduct.Data, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Data(val layout: View): RecyclerView.ViewHolder(layout){
        fun bind(product: Product){
            layout.findViewById<TextView>(R.id.idTextView).text = product.id.toString()
            layout.findViewById<TextView>(R.id.nameTextView).text = product.productName
            layout.findViewById<TextView>(R.id.descTextView).text = product.productDescription
        }
    }
}