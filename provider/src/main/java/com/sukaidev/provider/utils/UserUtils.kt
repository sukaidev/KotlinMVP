package com.sukaidev.provider.utils

import android.view.View
import android.widget.TextView
import com.sukaidev.common.common.UserConstant
import com.sukaidev.common.ext.loadUrl
import com.sukaidev.common.widgets.AppToolBar
import com.sukaidev.provider.R
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.find

object UserUtils {

    fun loadUser(header: View, mAppToolBar: AppToolBar){
        var avatar = header.find<CircleImageView>(R.id.mAvatar)
        var username = header.find<TextView>(R.id.mUsername)
        var mail = header.find<TextView>(R.id.mMail)
        val userAvatar = AppPrefsUtils.getString(UserConstant.KEY_SP_USER_ICON)
        if (userAvatar.isNotEmpty()) {
            avatar.loadUrl(userAvatar)
        }
        username.text = "hello"
        mail.text = "xxx@gmail.com"
        mAppToolBar.setAvatarOnInternet(userAvatar)
    }
}