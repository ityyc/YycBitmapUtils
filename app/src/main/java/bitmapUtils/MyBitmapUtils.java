package bitmapUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Author ：yuanyc
 * Time ：2017/4/28
 * Description ：bitmap处理工具类
 */

public class MyBitmapUtils {

    /**
     * 按照固定高度进行压缩bitmap
     *
     * @param responseData
     * @param displayHeight
     * @return
     */
    public static Bitmap compressBitmapByHeight(byte[] responseData, int displayHeight) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(responseData, 0, responseData.length);
        int bitmapHeight = bitmap.getHeight();
        int bitmapWidth = bitmap.getWidth();
        Matrix matrix = new Matrix();
        float scaleHeight = ((float) displayHeight / bitmapHeight);
        matrix.postScale(1, scaleHeight);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, true);
        if (null != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return newBitmap;
    }

    /**
     * 按照固定宽度进行压缩bitmap
     *
     * @param responseData
     * @param displayWidth
     * @return
     */
    public static Bitmap compressBitmapByWidth(byte[] responseData, int displayWidth) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(responseData, 0, responseData.length);
        int bitmapHeight = bitmap.getHeight();
        int bitmapWidth = bitmap.getWidth();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) displayWidth / bitmapWidth);
        matrix.postScale(scaleWidth, 1);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, true);
        if (null != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return newBitmap;
    }

    /**
     * 按照固定宽度和高度进行压缩bitmap
     *
     * @param responseData
     * @param displayWidth
     * @return
     */
    public static Bitmap compressBitmapByWH(byte[] responseData, int displayWidth, int displayHeight) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(responseData, 0, responseData.length);
        int bitmapHeight = bitmap.getHeight();
        int bitmapWidth = bitmap.getWidth();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) displayWidth / bitmapWidth);
        float scaleHeight = ((float) displayHeight / bitmapHeight);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, true);
        if (null != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return newBitmap;
    }

}
