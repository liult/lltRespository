package com.dayi.app.base.mvp;

/**
 * Created by zhilian-2 on 2016/7/4.
 */
public interface BaseInterfaceView {

    void showLoadingProgress();

    void hideLoadingProgerss();

    void showNetWorkErrorView();

    void showNoDataView();

    void showServiceErrorView();

    void removeStatusView();
}
