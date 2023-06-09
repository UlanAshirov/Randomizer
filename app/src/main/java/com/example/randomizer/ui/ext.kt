package com.example.randomizer.ui

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}