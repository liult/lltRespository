package com.dayi.app.base.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.dayi.app.base.BaseActivity;

/**
 * MVP
 * @param <P> presenter
 */
public abstract class BaseMVPActivity<V, P extends BasePresenter<V>> extends BaseActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //先初始化presenter
        this.mPresenter = createPresenter();
        getPresenter().attachView((V) this);
        super.onCreate(savedInstanceState);
        getPresenter().onUICreate(savedInstanceState);
    }

    /**
     * createPresenter:创建一个Presenter，子类来实现，可以通过new的方式直接new出来一个. <br/>
     */
    protected abstract P createPresenter();

    /**
     * getPresenter:子类应该通过这个方法拿到Presenter的实例，而不是通过变量拿到. <br/>
     */
    protected final P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onUIStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onUIResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onUIPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onUIStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onUIDestroy();
        getPresenter().detachView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getPresenter().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        getPresenter().onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getPresenter().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
