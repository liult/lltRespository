package com.dayi.app.presenter;

import com.dayi.app.appInterface.viewInterface.HomeSortView;
import com.dayi.app.base.mvp.BasePresenter;
import com.dayi.app.biz.TechnologyMoudle;

/**
 * 首页分类下面最新信息
 * Created by liuletao on 2016/7/4.
 */
public class NewestInfoPresenter extends BasePresenter<HomeSortView>{

    private TechnologyMoudle mMoudle;

    public NewestInfoPresenter() {
        mMoudle = new TechnologyMoudle();
    }


    public void getAppconfigs(){
        mMoudle.getData();
    }
}
