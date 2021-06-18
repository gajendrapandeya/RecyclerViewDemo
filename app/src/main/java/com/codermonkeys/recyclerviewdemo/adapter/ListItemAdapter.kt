package com.codermonkeys.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.codermonkeys.recyclerviewdemo.databinding.ItemListBinding
import com.codermonkeys.recyclerviewdemo.model.ListItem

class ListItemAdapter(
    private val listItems: List<ListItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItemViewHolder {
        val itemBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount() = listItems.size

    inner class ListItemViewHolder(private val itemBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {
        fun bind(listItem: ListItem) {
            itemBinding.ivNoteImage.load(listItem.image) {
                diskCachePolicy(CachePolicy.ENABLED)
                transformations(CircleCropTransformation())
            }

            itemBinding.tvNoteTitle.text = listItem.title
            itemBinding.tvNoteDescription.text = listItem.description
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}