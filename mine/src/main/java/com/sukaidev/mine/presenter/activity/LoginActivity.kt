package com.sukaidev.mine.presenter.activity

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import com.sukaidev.common.ext.onClick
import com.sukaidev.common.presenter.activity.AppMvpActivity
import com.sukaidev.mine.R
import com.sukaidev.mine.data.entity.UserInfo
import com.sukaidev.mine.presenter.LoginPresenter
import com.sukaidev.mine.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.find

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
class LoginActivity : AppMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    private var mForgetPwdBtn: TextView? = null

    override fun injectComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun layoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 初始化视图
     */
    override fun initView() {
        mLoginLayout.setBackgroundResource(R.drawable.login_bg)
        mForgetPwdBtn = find(R.id.mForgetPwdBtn)
        mForgetPwdBtn!!.paint.isAntiAlias = true
        mForgetPwdBtn!!.paint.flags = Paint.UNDERLINE_TEXT_FLAG

        // 登录
        mLoginBtn.onClick(this)
        // 注册
//        mTitleLayout.onClick(this)

    }

    /**
     * 初始化数据
     */
    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginResult(result: UserInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}