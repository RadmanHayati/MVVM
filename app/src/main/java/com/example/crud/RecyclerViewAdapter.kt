package com.example.crud

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.databinding.ListItemBinding
import com.example.crud.db.Subscriber

class RecyclerViewAdapter(private val subscribers: List<Subscriber>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(subscribers[position])
    }

    override fun getItemCount(): Int {
     return subscribers.size
    }

}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(subscriber: Subscriber) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        Log.i("MYTAG","im in adapter")
    }

}