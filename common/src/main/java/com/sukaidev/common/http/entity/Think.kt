package com.sukaidev.common.http.entity

/**
 * Created by sukaidev on 2019/07/28.
 *
 * 通用数据返回实现
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */
data class Think<out T>(val status: Int, val message: String, val data: T)