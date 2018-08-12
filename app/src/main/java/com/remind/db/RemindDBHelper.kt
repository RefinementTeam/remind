package com.remind.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.remind.RemindApplication

/**
 * 提醒数据库
 */
class RemindDBHelper private constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    private var sql: SQLiteDatabase;

    companion object {
        fun getInstence() = Holder.instance
    }

    private object Holder {
        val instance = RemindDBHelper(RemindApplication.getContext(), "remind.db3", null, 1)
    }

    init {
        sql = readableDatabase
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //创建过得提醒保存
        db?.execSQL("create table creatremind(_id integer PRIMARY KEY AUTOINCREMENT,finishtime long,content text,ring text,autochange integer,notify integer,imagepath text,classify integer)")
        //正在执行的提醒
        db?.execSQL("create table executeremind(_id integer PRIMARY KEY AUTOINCREMENT,finishtime long,content text,ring text,autochange integer,notify integer,imagepath text,classify integer)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        //数据库升级
    }

    //获取所有提醒
    fun getCreatRemind(): MutableList<RemindContent> {
        val list = mutableListOf<RemindContent>()
        val cursor = sql.rawQuery("select *from creatremind", arrayOf<String>())
        while (cursor.moveToNext()) {
            //id
            val idid = cursor.getColumnIndex("_id")
            val id = cursor.getInt(idid)
            // finishtime
            val finishtimeid = cursor.getColumnIndex("finishtime")
            val finishtime = cursor.getLong(finishtimeid)
            //content
            val contentid = cursor.getColumnIndex("content")
            val content = cursor.getString(contentid)
            //ring
            val ringid = cursor.getColumnIndex("ring")
            val ring = cursor.getString(ringid)
            //autochange
            val autochangeid = cursor.getColumnIndex("autochange")
            val autochange = cursor.getInt(autochangeid)
            //notify
            val notifyid = cursor.getColumnIndex("notify")
            val notify = cursor.getInt(notifyid)
            //image path
            val imagepathid = cursor.getColumnIndex("imagepath")
            val imagepath = cursor.getString(imagepathid)
            //classify
            val classifyid = cursor.getColumnIndex("classify")
            val classify = cursor.getInt(classifyid)
            val remindContent = RemindContent(id, finishtime, content, ring, autochange, notify, imagepath, classify)
            list.add(remindContent)
        }
        cursor.close()
        return list
    }

    //保存提醒
    fun addRemind(remindContent: RemindContent) {
        sql.execSQL("insert into creatremind(finishtime,content,ring,autochange,notify,imagepath,classify) values(?,?,?,?,?,?,?)",
                arrayOf<String>(remindContent.finishTime.toString(), remindContent.content, remindContent.ring, remindContent.autoChange.toString()
                        , remindContent.notify.toString(), remindContent.imagePath, remindContent.remindClassify.toString()))
    }

    //修改提醒
    fun changeRemind(remindContent: RemindContent) {
        sql.execSQL("UPDATE creatremind SET finishtime = ?,content = ?,ring = ?,autochange = ?,notify = ?,imagepath = ?,classify = ? WHERE _id = ?",
                arrayOf<String>(remindContent.finishTime.toString(), remindContent.content, remindContent.ring, remindContent.autoChange.toString(), remindContent.notify.toString(), remindContent.id.toString()
                        , remindContent.imagePath, remindContent.remindClassify.toString()))
    }

    //删除提醒
    fun deleteRemind(remindContent: RemindContent) {
        sql.execSQL("delete from creatremind where finishtime = ?", arrayOf(remindContent.finishTime))
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //获取所有执行提醒
    fun getExRemind(): MutableList<RemindContent> {
        val list = mutableListOf<RemindContent>()
        val cursor = sql.rawQuery("select *from executeremind", arrayOf<String>())
        while (cursor.moveToNext()) {
            //id
            val idid = cursor.getColumnIndex("_id")
            val id = cursor.getInt(idid)
            // finishtime
            val finishtimeid = cursor.getColumnIndex("finishtime")
            val finishtime = cursor.getLong(finishtimeid)
            //content
            val contentid = cursor.getColumnIndex("content")
            val content = cursor.getString(contentid)
            //ring
            val ringid = cursor.getColumnIndex("ring")
            val ring = cursor.getString(ringid)
            //autochange
            val autochangeid = cursor.getColumnIndex("autochange")
            val autochange = cursor.getInt(autochangeid)
            //notify
            val notifyid = cursor.getColumnIndex("notify")
            val notify = cursor.getInt(notifyid)
            //image path
            val imagepathid = cursor.getColumnIndex("imagepath")
            val imagepath = cursor.getString(imagepathid)
            //classify
            val classifyid = cursor.getColumnIndex("classify")
            val classify = cursor.getInt(classifyid)
            val remindContent = RemindContent(id, finishtime, content, ring, autochange, notify, imagepath, classify)
            list.add(remindContent)
        }
        cursor.close()
        return list
    }

    //新增提醒任务
    fun addExRemind(remindContent: RemindContent) {
        sql.execSQL("insert into executeremind(finishtime,content,ring,autochange,notify,imagepath,classify) values(?,?,?,?,?,?,?)",
                arrayOf<String>(remindContent.finishTime.toString(), remindContent.content, remindContent.ring, remindContent.autoChange.toString()
                        , remindContent.notify.toString(), remindContent.imagePath, remindContent.remindClassify.toString()))
    }

    //删除提醒任务
    fun deleteExRemind(remindContent: RemindContent) {
        sql.execSQL("delete from executeremind where finishtime = ?", arrayOf(remindContent.finishTime))
    }

    //修改提醒任务
    fun changeExRemind(remindContent: RemindContent) {
        sql.execSQL("UPDATE executeremind SET finishtime = ?,content = ?,ring = ?,autochange = ?,notify = ?,imagepath = ?,classify = ? WHERE _id = ?",
                arrayOf<String>(remindContent.finishTime.toString(), remindContent.content, remindContent.ring, remindContent.autoChange.toString(), remindContent.notify.toString(), remindContent.id.toString()
                        , remindContent.imagePath, remindContent.remindClassify.toString()))
    }

}