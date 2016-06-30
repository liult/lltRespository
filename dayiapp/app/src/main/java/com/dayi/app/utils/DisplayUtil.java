package com.dayi.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import com.dayi.app.AppApplacation;

import java.io.InputStream;


public class DisplayUtil {

    public static int getWidth() {
        return AppApplacation.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getHeight() {
        return AppApplacation.getInstance().getResources().getDisplayMetrics().heightPixels;
    }

    /*public static int getContextHeight(){
        Rect frame = new Rect();
        AppApplacation ac =AppApplacation.getInstance();
        ac.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        return statusBarHeight;
    }*/

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     */
    public static int px2dip( float pxValue) {
        final float scale = AppApplacation.getInstance().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     */
    public static int dip2px(float dipValue) {
        final float scale =  AppApplacation.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp( float pxValue) {
        final float fontScale =  AppApplacation.getInstance().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     */
    public static int sp2px( float spValue) {
        final float fontScale =  AppApplacation.getInstance().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 使用native方式尽量少的消耗内存读取文件资源
     * @param context
     * @param resource
     * @return
     */
    public static  BitmapDrawable getBitmapDrawable(Context context,int resource){
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resource);
        Bitmap bm = BitmapFactory.decodeStream(is, null, opt);
        return new BitmapDrawable(context.getResources(), bm);
    }

//    /**
//     * 处理网络请求错误提示
//     * @param error
//     */
//    public static void handleErrorNetworkResult(Context context, AHError error){
//        if (context == null || error == null) return;
//        if (DeviceUtils.isNetWorkConnected()) {
//            ToastUtil.showMsg(StringUtils.isEmpty(error.errorMsg) ? context.getString(R.string.common_service_error) : error.errorMsg);
//        } else{
//            ToastUtil.showMsg(context.getString(R.string.common_network_error));
//        }
//    }
}