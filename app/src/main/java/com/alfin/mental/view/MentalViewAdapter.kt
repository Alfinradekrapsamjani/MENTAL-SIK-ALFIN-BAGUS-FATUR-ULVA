package com.alfin.mental.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alfin.mental.data.Mental
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dendi.organ.R


class MentalViewAdapter(private val listMental: ArrayList<Mental>) : RecyclerView.Adapter<MentalViewAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var onButtonClickCallback: OnItemClickCallback
    private lateinit var onFavoriteClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setOnButtonClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onButtonClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_card_data, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int){
        val organ = listMental[position]
        Glide.with(holder.itemView.context)
            .load(organ.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = organ.name
        holder.tvLatinName.text = organ.latinName

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMental[holder.adapterPosition]) }
        //using button share to whatsApp!
        holder.btnShare.setOnClickListener {
            onButtonClickCallback.onItemClicked(listMental[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {
        return listMental.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvLatinName: TextView = itemView.findViewById(R.id.tv_item_latinName)
        var btnShare: ImageButton = itemView.findViewById(R.id.btn_set_share)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Mental)
    }
}