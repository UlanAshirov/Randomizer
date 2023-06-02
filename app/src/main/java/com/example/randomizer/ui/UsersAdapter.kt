package com.example.randomizer.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat.clearColorFilter
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.randomizer.R
import com.example.randomizer.databinding.ItemUsersBinding
import com.example.randomizer.remote.model.MainResponseItem

class UsersAdapter(private val list: ArrayList<MainResponseItem>) :
    Adapter<UsersAdapter.UsersViewHolder>() {
    private var selectedImage: String? = null

    fun setSelectedImage(image: String?) {
        selectedImage = image
    }

    inner class UsersViewHolder(private val binding: ItemUsersBinding) : ViewHolder(binding.root) {
        fun onBind(image: String, isSelected: Boolean) {
            binding.itemImgUser.loadImage(image)
            binding.itemTvUserName.text = list[adapterPosition].name

            when (list[adapterPosition].gender) {
                "Мужской" -> binding.itemContainer.setBackgroundResource(R.drawable.circle_man_bg)
                "Женский" -> binding.itemContainer.setBackgroundResource(R.drawable.circle_woman_bg)
            }
            if (isSelected) {
                if (isBackgroundYellow()) {
                    when (list[adapterPosition].gender) {
                        "Мужской" -> binding.itemContainer.setBackgroundResource(R.drawable.circle_man_bg)
                        "Женский" -> binding.itemContainer.setBackgroundResource(R.drawable.circle_woman_bg)
                    }
                } else {

                    binding.itemContainer.setBackgroundResource(R.drawable.circle_selected_bg)
                }
            } else {
                when (list[adapterPosition].gender) {
                    "Мужской" -> binding.itemContainer.setBackgroundResource(R.drawable.circle_man_bg)
                    "Женский" -> binding.itemContainer.setBackgroundResource(R.drawable.circle_woman_bg)
                }
                /*itemView.context.resources.getColor(android.R.color.white)*/
            }
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        private fun isBackgroundYellow(): Boolean {
            val color =
                binding.itemImgUser.background?.constantState?.newDrawable()?.mutate()?.run {
                    clearColorFilter()
                    binding.itemImgUser.background = this
                    return@run this.constantState == itemView.context.resources.getDrawable(
                        android.R.color.holo_green_light
                    ).constantState
                }
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder(
        ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val image = list[position].image
        holder.onBind(image, image == selectedImage)
    }
}
