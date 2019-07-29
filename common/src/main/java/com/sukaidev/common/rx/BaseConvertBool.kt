package com.sukaidev.common.rx

import com.sukaidev.common.common.ResultCode
import com.sukaidev.common.http.entity.Think
import rx.Observable
import rx.functions.Func1

/**
 * Created by sukaidev on 2019/07/29.
 * 对Boolean类型的通用处理
 */
class BaseConvertBool<T> : Func1<Think<T>, Observable<Boolean>> {
    override fun call(t: Think<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(true)

    }
}