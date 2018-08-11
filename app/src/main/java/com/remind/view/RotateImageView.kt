package com.remind.view


class RotateImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    val imagePaint: Paint
    val bottomPaint: Paint
    lateinit var showBitmap: Bitmap
    var viewWidth = 0f
    var viewHeight = 0f
    lateinit var rectF: RectF
    var shouldDraw = false

    init {
        imagePaint = Paint()
        imagePaint.isAntiAlias = true
        imagePaint.isDither = true
        bottomPaint = Paint()
        imagePaint.isAntiAlias = true
        imagePaint.isDither = true
        viewWidth = 1.0f * (1080 - 100) / 2
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

        canvas?.drawRoundRect(rectF, 30f, 30f, bottomPaint)
        imagePaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        canvas?.drawBitmap(showBitmap, null, rectF, imagePaint)

        canvas?.restoreToCount(layerId!!)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(viewWidth.toInt(), viewHeight.toInt())
    }

}