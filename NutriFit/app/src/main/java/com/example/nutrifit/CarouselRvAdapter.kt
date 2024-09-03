package com.example.nutrifit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CarouselRVAdapter(private val imageResourceIds: List<Int>) :
    RecyclerView.Adapter<CarouselRVAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return CarouselItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        holder.imageView.setImageResource(imageResourceIds[position])
    }

    override fun getItemCount(): Int {
        return imageResourceIds.size
    }
}
