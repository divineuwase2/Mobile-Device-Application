package com.example.recyclerlistview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(var context:Context, var product:ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.productImage.setImageResource(product[position].image.toInt())
        holder.productTitle.text = product[position].title
        holder.productColor.text = product[position].color
        holder.productPrice.text = product[position].price.toString()

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, ProductDetail::class.java)
           // var res = product[position]
            intent.putExtra("product", product[position])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_product_layout, parent, false)
        return MyViewHolder(v);
    }
    override fun getItemCount(): Int {
        return product.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var productTitle: TextView = itemView.findViewById<TextView>(R.id.tv1)
        var productColor: TextView = itemView.findViewById<TextView>(R.id.tv2)
        var productPrice: TextView = itemView.findViewById<TextView>(R.id.tv3)
        var productImage : ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

}