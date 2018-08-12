package com.remind.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.remind.Utils


class RotateImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    val imagePaint: Paint
    val bottomPaint: Paint
    lateinit var showBitmap: Bitmap
    var viewWidth = 0f
    var viewHeight = 0f
    lateinit var rectF: RectF
    var shouldDraw = false
    var rotate = 10f

    init {
        imagePaint = Paint()
        imagePaint.isAntiAlias = true
        imagePaint.isDither = true
        bottomPaint = Paint()
        imagePaint.isAntiAlias = true
        imagePaint.isDither = true
        viewWidth = 1.0f * (Utils.getScreen().x - Utils.dp2px(32f)) / 2
        rotate = Utils.dp2px(6f).toFloat()
    }

    fun setBitmap(bitmap: Bitmap) {
        showBitmap = bitmap
        viewHeight = 1.0f * viewWidth / bitmap.width * bitmap.height

        val pamras = layoutParams
        pamras.width = viewWidth.toInt()
        pamras.height = viewHeight.toInt()
        layoutParams = pamras

        rectF = RectF(0f, 0f, viewWidth, viewHeight)

        shouldDraw = true

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (!shouldDraw) return
        val layerId = canvas?.saveLayer(0f, 0f, viewWidth, viewHeight, null, Canvas.ALL_SAVE_FLAG)

        canvas?.drawRoundRect(rectF, rotate, rotate, bottomPaint)
        imagePaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        canvas?.drawBitmap(showBitmap, null, rectF, imagePaint)

        canvas?.restoreToCount(layerId!!)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(viewWidth.toInt(), viewHeight.toInt())
    }

}