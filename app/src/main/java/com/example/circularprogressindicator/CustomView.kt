package com.example.circularprogressindicator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.circularprogressindicator.databinding.LayoutCustomLayoutBinding

class CustomView(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    val binding: LayoutCustomLayoutBinding

    init {

        binding = LayoutCustomLayoutBinding.bind(
            View.inflate(context, R.layout.layout_custom_layout, this)
        )

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView, INIT_VALUE, INIT_VALUE)
        binding.displayImage.setImageResource(
            typedArray.getResourceId(
                R.styleable.CustomView_image,
                R.drawable.ic_mute_light
            )
        )
        setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        typedArray.recycle()

        setBackgroundColor(ContextCompat.getColor(context, R.color.white))

        binding.circleIndicator.progress = INIT_VALUE

    }

    fun updateProgress(count: Int) {
        binding.circleIndicator.progress = count
        binding.count.text = count.toString()
    }

    fun changeTrackColor(color: Int) {
        binding.circleIndicator.trackColor = color
    }

    fun changeIndicatorColor(color: Int) {
        binding.circleIndicator.setIndicatorColor(color)
    }

    fun changeImage(image: Int) {
        binding.displayImage.setImageResource(image)
    }
    companion object {
        const val INIT_VALUE = 0
    }
}
