package com.sukaidev.common.utils

import android.content.Context

/**
 * Created by sukaidev on 2019/7/28.
 * 全局工具类.
 */
object AppUtils {

    fun dp2px(dp: Float, mContext: Context): Int {
        val scale = mContext.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

}