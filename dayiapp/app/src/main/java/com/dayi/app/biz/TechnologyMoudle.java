package com.dayi.app.biz;

import com.dayi.app.AppApplacation;
import com.dayi.app.bean.AppConfigs;
import com.dayi.app.network.RetrofitDataService;
import com.dayi.app.utils.UiUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by liuletao on 2016/7/4.
 */
public class TechnologyMoudle {
//    private String token = "a14ff3d45d7b21ede0917d3d91cbbd5c";
    private String token = null;

    public void getData() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (token == null) {
                    subscriber.onCompleted();
                } else {
                    subscriber.onNext(token);
                }
            }
        }).flatMap(new Func1<String, Observable<AppConfigs>>() {
            @Override
            public Observable<AppConfigs> call(String s) {
                return RetrofitDataService.getInstance().mResetService.getAppConfig("test", s);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppConfigs>() {
                    @Override
                    public void onCompleted() {
                        UiUtil.showToast(AppApplacation.getInstance(),
                                "onCompleted:");
                    }

                    @Override
                    public void onError(Throwable e) {
                        UiUtil.showToast(AppApplacation.getInstance(),
                                "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(AppConfigs appConfigs) {
                        UiUtil.showToast(AppApplacation.getInstance(),
                                "tel:"+ appConfigs.app_config.getCustomer_service_tel());
                    }
                });
    }

}
