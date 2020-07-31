package com.mmc.colud.hystrix.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * @packageName：com.mmc.colud.hystrix.rxjava
 * @desrciption:
 * @author: GW
 * @date： 2020-07-31 13:41
 * @history: (version) author date desc
 */
public class ObservableMock {

    /**
     * 创建事件源
     */
    static Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello RxJava");
            subscriber.onNext("command rxJava");
            subscriber.onCompleted();
        }
    });

    /**
     * 订阅者
     */
    static Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            System.out.println("Subscribe : " + s);
        }
    };

    public static void main(String[] args) {
        // 订阅
        observable.subscribe(subscriber);
    }
}
