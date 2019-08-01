package com.sukaidev.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.sukaidev.common.common.Constant
import com.sukaidev.provider.router.RouterPath

/**
 * Created by sukaidev on 2019/08/01.
 * 顶级函数，判断是否登录.
 */
fun isLogin():Boolean{
    return AppPrefsUtils.getString(Constant.KEY_SP_TOKEN).isNotEmpty()
}

/**
 * 如果已经登录，进行传入的方法处理
 * 如果没有登录，进入登录界面
 */
fun afterLogin(method:()->Unit){
    if (isLogin()){
        method()
    }else{
        ARouter.getInstance().build(RouterPath.MineModule.LOGIN_PATH).navigation()
    }
}