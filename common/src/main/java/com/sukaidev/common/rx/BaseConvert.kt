package com.sukaidev.common.rx

import com.sukaidev.common.common.ResultCode
import com.sukaidev.common.http.entity.Think
import rx.Observable
import rx.functions.Func1

/**
 * Created by sukaidev on 2019/07/29.
 * 通用数据处理.
 */
class BaseConvert<T> : Func1<Think<T>, Observable<T>> {
    override fun call(t: Think<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data )
    }
}