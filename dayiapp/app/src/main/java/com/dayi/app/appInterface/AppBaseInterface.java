package com.dayi.app.appInterface;

import android.view.View;
import android.view.ViewGroup;

import retrofit2.Callback;


/**
 * 基类接口
 * Created by zhilian-2 on 2016/1/15.
 */
public interface AppBaseInterface extends Callback {
    /**
     * 设置fragment自定义头部信息
     * @param leftImageResourceId 左按钮图片资源
     * @param leftText 左边按钮左边文字
     * @param title 中间文字
     * @param rightImageResourceId 有按钮图片资源
     * @param rightText 有按钮文字
     */
    void initTitle(int leftImageResourceId, String leftText,
                   String title, int rightImageResourceId, String rightText);

    void initTitle(View view, int leftImageResourceId, String leftText,
                   String title, int rightImageResourceId, String rightText);
    /**
     * 得到左textview
     * @return
     */
    View getDivTitleLeftView();
    /**
     * 得到右textview
     * @return
     */
    View getDivTitleRightView();

    /**
     * 显示加载loading
     */
    void showLoadingProgress(ViewGroup view);
    /**
     * 隐藏加载loading
     */
    void hideLoadingProgress(ViewGroup view);
}
