package com.sukaidev.mine.data.entity

/**
 * Created by sukaidev on 2019/08/01.
 * 注册请求实体.
 */
data class RegisterRequest(val phone: String, val pwd: String, val verifyCode: String)