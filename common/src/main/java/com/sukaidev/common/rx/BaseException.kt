package com.sukaidev.common.rx

/**
 * Created by sukaidev on 2019/07/29.
 * 全局异常.
 */
class BaseException(val status: Int, val msg: String) : Throwable()