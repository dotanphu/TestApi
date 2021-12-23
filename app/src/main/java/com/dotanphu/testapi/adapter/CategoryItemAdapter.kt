package com.dotanphu.testapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dotanphu.testapi.databinding.ItemListCategoryBinding
import com.dotanphu.testapi.model.CategoryItem

class CategoryItemAdapter(
    private var listCategory: List<CategoryItem>,
    private var context: Context
) :
    RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryItemAdapter.ViewHolder {
        return ViewHolder(
            ItemListCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }

    override fun onBindViewHolder(holder: CategoryItemAdapter.ViewHolder, position: Int) {
        holder.bind(listCategory[position])
    }

    override fun getItemCount() = listCategory.size

    class ViewHolder(private var binding: ItemListCategoryBinding, private var context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItem: CategoryItem) {
            binding.tvId.text = categoryItem.id.toString()
            binding.tvTittle.text = categoryItem.title
            binding.tvDescription.text = categoryItem.description
            Glide.with(context).load(categoryItem.image).into(binding.imgCategory)
        }
    }
}