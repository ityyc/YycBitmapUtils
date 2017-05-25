package bitmapUtils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.example.yuanyc.mybitmaputils.GlobalUtils;

import java.io.ByteArrayOutputStream;

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

    /**
     * 压缩图片,通过采样率进行压缩
     *
     * @param id 资源的id
     * @return
     */
    public static Bitmap compressBitmap(int id) {
        Resources resources = GlobalUtils.getInstance().getMainActivity().getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.decodeResource(resources, id, options);
        options.inJustDecodeBounds = true;
        options.inSampleSize = 4;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, id, options);
        return bitmap;
    }

    /**
     *
     * @param bitmap 要压缩的bitmap
     * @param quality 质量 0-100,100表示原图
     * @return
     */
    public static Bitmap compressLossBitmap(Bitmap bitmap,int quality){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,quality,baos);
        System.out.println("压缩之后大小："+baos.toByteArray().length);
        return BitmapFactory.decodeByteArray(baos.toByteArray(),0,baos.toByteArray().length);
    }

}
