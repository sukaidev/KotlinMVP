package com.sukaidev.common.rx

import com.sukaidev.common.presenter.view.AppView
import rx.Subscriber

/**
 * Created by sukaidev on 2019/07/29.
 * 订阅者通用实现.
 */
open class BaseSubscriber<T>(val v: AppView) : Subscriber<T>() {
    override fun onError(e: Throwable?) {
        v.hideLoading()
        if (e is BaseException) {
            v.onError(e.msg)
        }
    }

    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        v.hideLoading()
    }
}