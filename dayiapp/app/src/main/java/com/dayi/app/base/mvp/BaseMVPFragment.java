package com.dayi.app.base.mvp;

import android.os.Bundle;

import com.dayi.app.base.BaseFragment;

/**
 * @describe MVP Fragment的基类.
 */
public abstract class BaseMVPFragment<V, P extends BasePresenter<V>> extends BaseFragment {

  protected P mPresenter;

  protected abstract P createPresenter();

  protected final P getPresenter() {
    return mPresenter;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    this.mPresenter = createPresenter();
    getPresenter().attachView((V) this);
    super.onCreate(savedInstanceState);
    getPresenter().onUICreate(savedInstanceState);
  }

  @Override public void onStart() {
    super.onStart();
    getPresenter().onUIStart();
  }

  @Override public void onStop() {
    super.onStop();
    getPresenter().onUIStop();
  }

  @Override public void onResume() {
    super.onResume();
    getPresenter().onUIResume();
  }

  @Override public void onPause() {
    super.onPause();
    getPresenter().onUIPause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    getPresenter().onUIDestroy();
//    getPresenter().detachView();
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    getPresenter().onSaveInstanceState(outState);
  }
}
