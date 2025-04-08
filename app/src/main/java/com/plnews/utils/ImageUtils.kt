package com.plnews.utils

import android.content.Context
import android.graphics.*
import androidx.core.content.res.ResourcesCompat
import com.plnews.R

object ImageUtils {

    fun generateImage(context: Context, text: String, template: TemplateType): Bitmap {
        val templateResId = when (template) {
            TemplateType.BREAKING -> R.drawable.template_breaking
            TemplateType.NORMAL -> R.drawable.template_normal
            TemplateType.UPDATE -> R.drawable.template_update
        }

        val templateBitmap = BitmapFactory.decodeResource(context.resources, templateResId)
        return drawTextOnBitmap(context, templateBitmap, text)
    }

    fun drawTextOnBitmap(context: Context, bitmap: Bitmap, text: String): Bitmap {
        val resultBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(resultBitmap)

        val paint = Paint().apply {
            color = Color.WHITE
            textSize = 64f
            isAntiAlias = true
            typeface = ResourcesCompat.getFont(context, R.font.cairo)
        }

        val x = 50f
        val y = (bitmap.height / 2).toFloat()
        canvas.drawText(text, x, y, paint)

        return resultBitmap
    }
}
