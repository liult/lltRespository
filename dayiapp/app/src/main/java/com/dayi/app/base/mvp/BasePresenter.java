package com.dayi.app.base.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @describe 普通Presenter.
 */
public abstract class BasePresenter<V> implements IPresenter {

  private Reference<V> mViewRef; //View 接口的若饮用

  public void attachView(V view) {
    mViewRef = new WeakReference<>(view);
  }

  protected V getView() {
    return mViewRef == null ? null : mViewRef.get();
  }

  public boolean isViewAttached() {
    return mViewRef != null && mViewRef.get() != null;
  }

  public void detachView() {
    if (mViewRef != null) {
      mViewRef.clear();
      mViewRef = null;
    }
  }

  @Override public void onUICreate(Bundle savedInstanceState) {

  }

  @Override public void onUIStart() {

  }

  @Override public void onUIResume() {

  }

  @Override public void onUIPause() {

  }

  @Override public void onUIStop() {

  }

  @Override public void onUIDestroy() {

  }

  @Override public void onSaveInstanceState(Bundle outState) {

  }

  @Override public void onRestoreInstanceState(Bundle savedInstanceState) {

  }

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {

  }
}
