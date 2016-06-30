package com.dayi.app.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dayi.app.R;
import com.dayi.app.appInterface.AppBaseInterface;
import com.dayi.app.utils.LogUtil;
import com.dayi.app.utils.UiUtil;
import com.extras.com.utils.DataUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import retrofit2.Call;
import retrofit2.Response;


public abstract class BaseActivity extends AppCompatActivity implements AppBaseInterface {

    public RelativeLayout relMain;
    protected View loadingView = null;
    private TextView leftTv, titleTv, rightTv;
    public View titleView;
    private ViewGroup contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSystemBarColor();
        setContentView(R.layout.activity_base);
        relMain = (RelativeLayout) findViewById(R.id.rel_main);

        titleView = findViewById(R.id.base_activity_header_view);
        contentView = (ViewGroup) findViewById(R.id.base_activity_body_view);
        if (getBodyView() == 0) {
            LogUtil.e(this.getClass() + "", "the param of layout is error , the value is 0 ");
            return;
        }
        LayoutInflater.from(this).inflate(getBodyView(), contentView, true);
    }

    /**
     *
     * @return Activity's Layout
     */
    public abstract int getBodyView();

    public void setSystemBarColor() {
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        // 创建状态栏的管理实例
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // 激活状态栏设置
        tintManager.setStatusBarTintEnabled(true);
        // 激活导航栏设置
        tintManager.setNavigationBarTintEnabled(true);
        // 设置一个颜色给系统栏
        tintManager.setStatusBarTintColor(Color.parseColor("#12B7F5"));
    }

    @Override
    public void initTitle(View view, int leftImageResourceId, String leftText, String title, int rightImageResourceId, String rightText) {
    }

    @Override
    public void initTitle(int leftImageResourceId, String leftText, String title, int rightImageResourceId, String rightText) {
        leftTv = (TextView) titleView.findViewById(R.id.left_tv);
        titleTv = (TextView) titleView.findViewById(R.id.title_tv);
        rightTv = (TextView) titleView.findViewById(R.id.right_tv);
        if (leftTv == null || titleTv == null || rightTv == null) return;
        //中间文字设置
        if (!DataUtil.isEmpty(title)) {
            titleTv.setVisibility(View.VISIBLE);
            titleTv.setText(title);
        }else{
            titleTv.setVisibility(View.GONE);
        }
        //左部分图片文字设置
        if (leftImageResourceId <= 0 && DataUtil.isEmpty(leftText)){
            leftTv.setVisibility(View.GONE);
        }else {
            leftTv.setVisibility(View.VISIBLE);
            if (leftImageResourceId > 0){
                leftTv.setCompoundDrawablesWithIntrinsicBounds(leftImageResourceId, 0, 0, 0);
            }
            if (!DataUtil.isEmpty(leftText)){
                leftTv.setText(leftText);
            }
        }
        //右部分图片文字设置
        if (rightImageResourceId <= 0 && DataUtil.isEmpty(rightText)){
            rightTv.setVisibility(View.GONE);
        }else {
            rightTv.setVisibility(View.VISIBLE);
            if (rightImageResourceId > 0){
                rightTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, rightImageResourceId);
            }
            if (!DataUtil.isEmpty(rightText)){
                rightTv.setText(rightText);
            }
        }
        leftTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtil.showToast(BaseActivity.this, "click");
            }
        });
    }

    @Override
    public View getDivTitleLeftView() {
        return leftTv;
    }

    @Override
    public View getDivTitleRightView() {
        return rightTv;
    }

    @Override
    public void showLoadingProgress(ViewGroup view) {
        if (view == null) view = relMain;
        if (loadingView == null) {
            loadingView = LayoutInflater.from(this).inflate(R.layout.loading_view, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            view.addView(loadingView, params);
        }
        view.bringChildToFront(loadingView);
    }

    @Override
    public void hideLoadingProgress(ViewGroup view) {
        if (view == null) view = relMain;
        if (loadingView != null) {
            view.removeView(loadingView);
            loadingView = null;
        }
    }

    @Override
    public void onResponse(Call call, Response response) {

    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
