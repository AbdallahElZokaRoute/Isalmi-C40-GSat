package com.route.islamic40gsat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.route.islamic40gsat.R
import com.route.islamic40gsat.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    private lateinit var binding: FragmentTasbeehBinding
    private var currentRotation = 0f
    private var btnClickCount = 0
    private var i : Int = 0
    private val buttonText = listOf("سبحان الله" , "الحمد لله", "الله اكبر")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetFields()
        binding.sebhaBtn.setOnClickListener{
            if (i >= buttonText.size) i = 0
            btnClickCount++
            binding.tasbeehCountTv.text = "$btnClickCount"
            binding.sebhaBtn.text = buttonText.get(i)
            rotateImage()
            if (btnClickCount % 33 == 0){
                binding.sebhaBtn.text = buttonText.get(i)
                btnClickCount = 0
                i++
            }
        }

    }

    private fun resetFields(){
        binding.tasbeehCountTv.text = "0"
        binding.sebhaBtn.text = "ابدأ التسبيح"
        btnClickCount = 0
        i = 0
        resetImage()

    }

    private fun rotateImage() {
        val rotate = RotateAnimation(
            currentRotation,
            currentRotation + 10,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 500
            fillAfter = true
        }
        binding.sebhaBodyIv.startAnimation(rotate)
        currentRotation = (currentRotation + 10) % 360
    }

    private fun resetImage() {
        val reset = RotateAnimation(
            currentRotation,
            0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 500
            fillAfter = true
        }
        binding.sebhaBodyIv.startAnimation(reset)
        currentRotation = 0f
    }
}