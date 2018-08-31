package com.timmy.wanandroid.utils;

import com.timmy.wanandroid.model.http.exception.ApiException;
import com.timmy.wanandroid.model.http.response.HttpResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtil {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * 统一返回结果处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<HttpResponse<T>, T> handleResult() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<HttpResponse<T>, Observable<T>>) baseResponse -> {
                    if (baseResponse.getErrorCode() == 0
                            && baseResponse.getData() != null) {
                        return createData(baseResponse.getData());
                    } else {
                        return Observable.error(new ApiException("服务器返回error"));
                    }
                });
    }

    /**
     * 得到 Observable
     *
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    private static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }


    /**
     * 倒计时
     *
     * @param time
     * @return
     */
    public static Flowable<Integer> countDown(int time) {
        if (time < 0) {
            time = 0;
        }
        final int countTime = time;
        return Flowable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(aLong -> countTime - aLong.intValue())
                .take(countTime + 1);
    }
}
