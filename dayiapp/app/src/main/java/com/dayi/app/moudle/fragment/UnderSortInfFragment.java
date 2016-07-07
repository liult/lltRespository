package com.dayi.app.moudle.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dayi.app.R;
import com.dayi.app.appInterface.viewInterface.HomeSortView;
import com.dayi.app.base.mvp.BaseMVPFragment;
import com.dayi.app.moudle.adapter.HomeSortAdapter;
import com.dayi.app.presenter.NewestInfoPresenter;
import com.dayi.app.utils.pullRefreshView.PullToRefreshView;
import com.dayi.app.widget.loadingView.CatLoadingView;
import com.extras.com.pullToRefresh.PtrClassicFrameLayout;
import com.extras.com.pullToRefresh.PtrDefaultHandler;
import com.extras.com.pullToRefresh.PtrFrameLayout;
import com.extras.com.pullToRefresh.PtrHandler;
import com.extras.com.pullToRefresh.recyclerView.AutoLoadMoreRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuletao on 2016/7/4.
 */
public class UnderSortInfFragment extends BaseMVPFragment<HomeSortView, NewestInfoPresenter>
        implements HomeSortView {

    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.recyclerView)
    AutoLoadMoreRecyclerView recyclerView;
//    @BindView(R.id.ptrFrameLayout)
//    PtrClassicFrameLayout ptrFrameLayout;
    @BindView(R.id.pull_to_refresh)
    PullToRefreshView pullToRefresh;

    CatLoadingView mLoadingView;

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
        mHomeSortAdapter = new HomeSortAdapter(getActivity());
        getPresenter().getAppconfigs();
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    public void showDialog(){
        mLoadingView.show(getActivity().getSupportFragmentManager(), "");
    }
    private void initView() {
        mLoadingView = new CatLoadingView();
        recyclerView.setAdapter(mHomeSortAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        pullToRefresh.setRefreshing(true);
        pullToRefresh.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                showDialog();
                pullToRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingView.dismiss();
                        pullToRefresh.setRefreshing(false);
                    }
                }, 4000);
            }
        });

//        ptrFrameLayout.setLastUpdateTimeRelateObject(this);
//        ptrFrameLayout.setPtrHandler(new PtrHandler() {
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//            }
//
//            @Override
//            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
//                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
//            }
//        });
//        // the following are default settings
//        ptrFrameLayout.setResistance(1.7f);
//        ptrFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);
//        ptrFrameLayout.setDurationToClose(200);
//        ptrFrameLayout.setDurationToCloseHeader(1000);
//        // default is false
//        ptrFrameLayout.setPullToRefresh(false);
//        // default is true
//        ptrFrameLayout.setKeepHeaderWhenRefresh(true);
        //        ptrFrameLayout.postDelayed(new Runnable() {
        //            @Override
        //            public void run() {
        //                ptrFrameLayout.autoRefresh();
        //            }
        //        }, 100);
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
