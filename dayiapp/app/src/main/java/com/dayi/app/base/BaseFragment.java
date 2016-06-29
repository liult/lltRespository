package com.dayi.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dayi.app.R;
import com.dayi.app.appInterface.AppBaseInterface;
import com.extras.com.progress.SVProgressHUD;
import com.extras.com.utils.DataUtil;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

/**
 * fragment 基类
 * Created by zhilian-2 on 2016/1/7.
 */
public class BaseFragment extends Fragment implements AppBaseInterface {

    protected View loadingView = null;
    private SVProgressHUD mSVProgressHUD;
    private TextView leftTv, titleTv, rightTv;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initTitle(int leftImageResourceId, String leftText, String title, int rightImageResourceId, String rightText) {
    }

    @Override
    public void initTitle(View view, int leftImageResourceId, String leftText,
                          String title, int rightImageResourceId, String rightText){
        leftTv = (TextView) view.findViewById(R.id.left_tv);
        titleTv = (TextView) view.findViewById(R.id.title_tv);
        rightTv = (TextView) view.findViewById(R.id.right_tv);
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
                Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showLoadingProgress(ViewGroup view) {
        if (getActivity() == null) return;
        if (loadingView == null) {
            loadingView = LayoutInflater.from(getActivity()).inflate(R.layout.loading_view, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            view.addView(loadingView, params);
        }
        view.bringChildToFront(loadingView);
    }

    @Override
    public void hideLoadingProgress(ViewGroup view) {
        if (mSVProgressHUD == null) return;
        mSVProgressHUD.dismissImmediately();
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
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResponse(Call call, Response response) {

    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
