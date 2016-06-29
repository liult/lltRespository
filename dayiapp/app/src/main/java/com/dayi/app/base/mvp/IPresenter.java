package com.dayi.app.base.mvp;

import android.content.Intent;
import android.os.Bundle;

public interface IPresenter {

  /**
   *
   * onUICreate:UI被创建的时候应该invoke这个method. <br/>
   *
   * 比如Activity的onCreate()、Fragment的onCreateView()的方法应该调用Presenter的这个方法
   *
   * @author jiezi
   * @param savedInstanceState
   */
  void onUICreate(Bundle savedInstanceState);

  /**
   *
   * onUIStart:在UI被创建和被显示到屏幕之间应该回调这个方法. <br/>
   *
   * 比如Activity的onStart()方法应该调用Presenter的这个方法
   *
   * @author jiezi
   */
  void onUIStart();

  /**
   *
   * onUIResume:在UI被显示到屏幕的时候应该回调这个方法. <br/>
   *
   * 比如Activity的onResume()方法应该调用Presenter的这个方法
   *
   * @author jiezi
   */
  void onUIResume();

  /**
   *
   * onUIPause:在UI从屏幕上消失的时候应该回调这个方法. <br/>
   *
   * 比如Activity的onPause()方法应该调用Presenter的这个方法
   *
   * @author jiezi
   */
  void onUIPause();

  /**
   *
   * onUIStop:在UI从屏幕完全隐藏应该回调这个方法. <br/>
   *
   * 比如Activity的onStop()方法应该调用Presenter的这个方法
   *
   * @author jiezi
   */
  void onUIStop();

  /**
   *
   * onUIDestroy:当UI被Destory的时候应该回调这个方法. <br/>
   *
   * @author jiezi
   */
  void onUIDestroy();

  /**
   *
   * onSaveInstanceState:保存数据. <br/>
   *
   * 一般是因为内存不足UI的状态被回收的时候调用
   *
   * @author jiezi
   * @param outState
   */
  void onSaveInstanceState(Bundle outState);

  /**
   *
   * onRestoreInstanceState:当UI被恢复的时候被调用. <br/>
   *
   * @author jiezi
   * @param savedInstanceState
   */
  void onRestoreInstanceState(Bundle savedInstanceState);

  /**
   * onActivityForResult
   * @param requestCode
   * @param resultCode
   * @param data
   */
  void onActivityResult(int requestCode, int resultCode, Intent data);
}
