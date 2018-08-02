package com.remind.wallpager.ui

import android.graphics.*
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.remind.BaseActivity
import com.remind.R
import com.remind.wallpager.imagezoom.ImageViewTouch
import com.remind.wallpager.imagezoom.ImageViewTouchBase
import com.remind.wallpager.task.StickerTask
import com.remind.wallpager.view.WallEditView

class WallPagerEditActivity : BaseActivity(), View.OnClickListener,TextWatcher {
    private lateinit var wallEditView: WallEditView// 文字贴图显示控件
    private lateinit var mInputText: EditText//输入框
    private lateinit var mTextColorSelector: ImageView//颜色选择器
    lateinit var img: ImageViewTouch
    private lateinit var btn: Button
    private var mSaveTask: SaveTextStickerTask? = null
    private lateinit var bitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall_pager_edit)
        bitmap = BitmapFactory.decodeResource(resources,R.mipmap.c)
        initView()
    }

    private fun initView() {
        wallEditView = findViewById(R.id.wall_edit_view)
        mInputText = findViewById(R.id.text_input)
        mTextColorSelector = findViewById(R.id.text_color)
        img = findViewById(R.id.img)
        btn = findViewById(R.id.btn)
        mInputText.addTextChangedListener(this)
        wallEditView.setEditText(mInputText)
        wallEditView.setTextColor(Color.BLACK)
        img.setImageBitmap(bitmap)
        img.displayType = ImageViewTouchBase.DisplayType.FIT_TO_SCREEN
        btn.setOnClickListener(this)
    }

    override fun afterTextChanged(s: Editable) {
        val text = s.toString().trim({ it <= ' ' })
        wallEditView.setText(text)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)  = Unit

    override fun onClick(p0: View) {
        applyTextImage()
    }

    /**
     * 保存贴图图片
     */
    fun applyTextImage() {
        if (mSaveTask != null) {
            mSaveTask!!.cancel(true)
        }

        //启动任务
        mSaveTask = SaveTextStickerTask()
        mSaveTask!!.execute(bitmap)
    }

    /**
     * 文字合成任务
     * 合成最终图片
     */
    private inner class SaveTextStickerTask : StickerTask(this) {

        override fun handleImage(canvas: Canvas, m : Matrix) {
            val f = FloatArray(9)
            m.getValues(f)
            val dx = f[Matrix.MTRANS_X].toInt()
            val dy = f[Matrix.MTRANS_Y].toInt()
            val scale_x = f[Matrix.MSCALE_X]
            val scale_y = f[Matrix.MSCALE_Y]
            canvas.save()
            canvas.translate(dx.toFloat(), dy.toFloat())
            canvas.scale(scale_x, scale_y)
            wallEditView.drawText(canvas, wallEditView.layout_x,
                    wallEditView.layout_y, wallEditView.mScale, wallEditView.mRotateAngle)
            canvas.restore()
        }

        override fun onPostResult(result: Bitmap) {
            img.setImageBitmap(result)
            wallEditView.clearTextContent()
            wallEditView.resetView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mSaveTask != null && !mSaveTask!!.isCancelled) {
            mSaveTask!!.cancel(true)
        }
    }
}
