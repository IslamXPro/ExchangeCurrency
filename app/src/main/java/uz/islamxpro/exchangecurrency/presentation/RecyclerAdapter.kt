package com.example.exchangecurrency.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.islamxpro.exchangecurrency.R
import uz.islamxpro.exchangecurrency.databinding.CurrencyItemBinding
import uz.islamxpro.exchangecurrency.domain.model.CurrencyNBU

class RecyclerAdapter(private val currencies: List<CurrencyNBU>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CurrencyItemBinding.inflate(inflater)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    inner class RecyclerViewHolder(private val binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: CurrencyNBU) {
            binding.item = item
            binding.executePendingBindings()
            if (currencies.indexOf(item) % 2 != 0) {
                binding.RelativeLayout.setBackgroundResource(R.color.green_light)
            } else {
                binding.RelativeLayout.setBackgroundResource(R.color.white)
            }
        }
    }
}
