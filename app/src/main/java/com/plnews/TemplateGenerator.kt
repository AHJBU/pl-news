package com.plnews

import android.content.Context
import android.graphics.*
import androidx.core.content.res.ResourcesCompat

object TemplateGenerator {

    fun generateImage(context: Context, text: String, type: TemplateType): Bitmap {
        val width = 1080
        val height = 720
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val bgColor = when (type) {
            TemplateType.BREAKING -> Color.RED
            TemplateType.UPDATE -> Color.BLUE
            TemplateType.NORMAL -> Color.DKGRAY
        }

        canvas.drawColor(bgColor)

        val paint = Paint().apply {
            color = Color.WHITE
            textSize = 64f
            typeface = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
            isAntiAlias = true
        }

        val xPos = width / 2f
        val yPos = (height / 2f - (paint.descent() + paint.ascent()) / 2)

        canvas.drawText(text, xPos, yPos, paint)

        return bitmap
    }
}
