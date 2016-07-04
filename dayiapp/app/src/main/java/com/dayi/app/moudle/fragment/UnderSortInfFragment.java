package com.dayi.app.moudle.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dayi.app.R;
import com.dayi.app.appInterface.viewInterface.HomeSortView;
import com.dayi.app.base.mvp.BaseMVPFragment;
import com.dayi.app.moudle.adapter.HomeSortAdapter;
import com.dayi.app.presenter.NewestInfoPresenter;

/**
 * Created by liuletao on 2016/7/4.
 */
public class UnderSortInfFragment extends BaseMVPFragment<HomeSortView, NewestInfoPresenter>
        implements HomeSortView{

    private static final String ARG_SECTION_NUMBER = "section_number";

    private HomeSortAdapter mHomeSortAdapter;

    public static UnderSortInfFragment newInstance(int sectionNumber) {
        UnderSortInfFragment fragment = new UnderSortInfFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected NewestInfoPresenter createPresenter() {
        return new NewestInfoPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        mHomeSortAdapter = new HomeSortAdapter();
        getPresenter().getAppconfigs();
        return rootView;
    }

    @Override
    public void loadingDataSuccess() {

    }

    @Override
    public void LoadingDataFaild() {

    }

    @Override
    public void showLoadingProgress() {

    }

    @Override
    public void hideLoadingProgerss() {

    }

    @Override
    public void showNetWorkErrorView() {

    }

    @Override
    public void showNoDataView() {

    }

    @Override
    public void showServiceErrorView() {

    }

    @Override
    public void removeStatusView() {

    }
}
