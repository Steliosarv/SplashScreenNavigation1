package com.example.splashscreennavigation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.splashscreennavigation.databinding.ItemRecyclerBinding
import com.example.tvshowapp.models.TvShowItem

class HelloAdapter (): RecyclerView.Adapter<HelloAdapter.ViewHolder>() {

    private lateinit var  binding: ItemRecyclerBinding
    private val diffcalBack = object: DiffUtil.ItemCallback<TvShowItem>(){
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return  oldItem==newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffcalBack)

    var tvShows: List<TvShowItem> get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    inner class ViewHolder(item: ItemRecyclerBinding): RecyclerView.ViewHolder(item.root){
        fun bind (item: TvShowItem){
            binding.apply {
                textViewName.text=item.name
                textViewAddress.text= item.id.toString()

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelloAdapter.ViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        binding = ItemRecyclerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)



    }

    override fun onBindViewHolder(holder: HelloAdapter.ViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }


}