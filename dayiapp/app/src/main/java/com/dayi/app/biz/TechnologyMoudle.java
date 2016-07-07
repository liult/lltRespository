package com.dayi.app.biz;

import com.dayi.app.AppApplacation;
import com.dayi.app.bean.AppConfig;
import com.dayi.app.bean.AppConfigs;
import com.dayi.app.network.RetrofitDataService;
import com.dayi.app.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;

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

        AppConfig appConfig = new AppConfig();
        appConfig.setAgreement_url("www.baid.com");

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("www.baid.com");
            }
        }).lift(new Observable.Operator<AppConfig, String>() {
            @Override
            public Subscriber<? super String> call(Subscriber<? super AppConfig> subscriber) {



                return new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        String ss = s;
                    }
                };
            }
        }).subscribe(new Subscriber<AppConfig>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(AppConfig appConfig) {

            }
        });

        List<AppConfig> list = new ArrayList<>();
        Observable.from(list).flatMap(new Func1<AppConfig, Observable<AppConfig>>() {
            @Override
            public Observable<AppConfig> call(AppConfig appConfig) {
                return null;
            }
        }).subscribe(new Subscriber<AppConfig>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(AppConfig appConfig) {

            }
        });
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
