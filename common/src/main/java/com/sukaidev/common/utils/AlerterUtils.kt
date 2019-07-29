package com.sukaidev.common.utils

import android.app.Activity
import com.sukaidev.common.R
import com.tapadoo.alerter.Alerter

/**
 * Created by sukaidev on 2019/07/29.
 * Alerter封装.
 */
object AlerterUtils {

    fun error(activity: Activity,title: String,message: String){
        Alerter.create(activity)
            .setTitle(title)
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_error_bg)
            .setIcon(R.drawable.alert_error_icon)
            .show()
    }

    fun success(activity: Activity,title: String,message: String){
        Alerter.create(activity)
            .setTitle(title)
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_success_bg)
            .setIcon(R.drawable.alert_success_icon)
            .show()
    }

    fun warn(activity: Activity,title: String,message: String){
        Alerter.create(activity)
            .setTitle(title)
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_warn_bg)
            .setIcon(R.drawable.alert_warn_icon)
            .show()
    }
}