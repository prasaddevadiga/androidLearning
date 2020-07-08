package com.smartheard.kotlinrecyclerviewex1.Tourism.TourAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartheard.kotlinrecyclerviewex1.R
import com.smartheard.kotlinrecyclerviewex1.Tourism.model.Places
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tour_recyclerview_card.view.*

class TourAdapter(val context: Context, private val places: ArrayList<Places>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_recyclerview_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Download image
        Picasso.get()
            .load(places[position].url)
            .into(holder.itemView.tourImage)

        //Kenburns animation
        holder.itemView.tourImage.resume()

        holder.itemView.tourTitle.text = places[position].title
        holder.itemView.tourDescription.text = places[position].description
        holder.itemView.tourRating.rating = places[position].rating!!

    }

    class ViewHolder(v: View?): RecyclerView.ViewHolder(v!!), View.OnClickListener {

        override fun onClick(v: View?) {

        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}