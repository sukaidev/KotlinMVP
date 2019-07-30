package com.sukaidev.mine.utils

import com.sukaidev.common.common.Constant
import com.sukaidev.common.common.UserConstant
import com.sukaidev.mine.data.entity.UserInfo

/**
 * Created by sukaidev on 2019/07/30.
 * 本地存储用户相关信息.
 */
object UserPrefsUtils {

    /*
        退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(Constant.KEY_SP_TOKEN, userInfo?.userName ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_MOBILE, userInfo?.userPhone ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
    }
}
