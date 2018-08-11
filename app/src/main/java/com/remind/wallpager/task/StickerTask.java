package com.remind.wallpager.task;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Build;

import com.remind.wallpager.ui.WallPagerEditActivity;
import com.remind.wallpager.util.Matrix3;


/**
 * 贴图合成任务 抽象类
 */
public abstract class StickerTask extends AsyncTask<Bitmap, Void, Bitmap> {
    private WallPagerEditActivity mActivity;

    public StickerTask(WallPagerEditActivity activity) {
        mActivity = (WallPagerEditActivity) activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Bitmap... params) {

        Matrix touchMatrix = mActivity.img.getImageViewMatrix();

        Bitmap resultBit = Bitmap.createBitmap(params[0]).copy(
                Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(resultBit);

        float[] data = new float[9];
        touchMatrix.getValues(data);// 底部图片变化记录矩阵原始数据
        Matrix3 cal = new Matrix3(data);// 辅助矩阵计算类
        Matrix3 inverseMatrix = cal.inverseMatrix();// 计算逆矩阵
        Matrix m = new Matrix();
        m.setValues(inverseMatrix.getValues());

        handleImage(canvas, m);

        return resultBit;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCancelled(Bitmap result) {
        super.onCancelled(result);
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        onPostResult(result);
    }

    public abstract void handleImage(Canvas canvas, Matrix m);

    public abstract void onPostResult(Bitmap result);
}
