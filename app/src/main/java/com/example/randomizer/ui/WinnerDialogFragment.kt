package com.example.randomizer.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.randomizer.R
import com.example.randomizer.databinding.FragmentWinnerDialogBinding

class WinnerDialogFragment(
    private val image: String,
    private val name: String,
) : DialogFragment() {
    private lateinit var binding: FragmentWinnerDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWinnerDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawableResource(R.drawable.circle_selected_bg)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            binding.winnerImg.loadImage(image)
            binding.winnerTvName.text = name
        }, 2000)
    }
}