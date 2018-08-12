package com.remind.main.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.remind.R
import com.remind.db.RemindContent
import com.remind.view.RotateImageView

class MainAdapter(val context: Context, val list: MutableList<RemindContent>) : RecyclerView.Adapter<MainAdapter.ContentViewHolder>() {

    private var inflate: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MainAdapter.ContentViewHolder {
        val view: View = inflate.inflate(R.layout.mainadapterlayout, viewGroup, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MainAdapter.ContentViewHolder, i: Int) {
        viewHolder.setData(i)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val main_adapter_back: RotateImageView
        private val main_adapter_tv: TextView
        private val main_adapter_classify: ImageView
        private val main_adapter_time: TextView

        init {
            main_adapter_back = itemView.findViewById(R.id.main_adapter_back)
            main_adapter_tv = itemView.findViewById(R.id.main_adapter_tv)
            main_adapter_classify = itemView.findViewById(R.id.main_adapter_classify)
            main_adapter_time = itemView.findViewById(R.id.main_adapter_time)
        }

        fun setData(position: Int) {
            val content: RemindContent = list[position]
            main_adapter_back.setBitmap(BitmapFactory.decodeResource(context.resources, R.mipmap.main_clock_back))
            main_adapter_tv.setText(content.content)
        }
    }
}