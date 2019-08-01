package com.sukaidev.mine.presenter.activity

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.sukaidev.common.common.AppManager
import com.sukaidev.common.ext.onClick
import com.sukaidev.common.ext.startTop
import com.sukaidev.common.presenter.activity.AppMvpActivity
import com.sukaidev.common.utils.AlerterUtils
import com.sukaidev.common.widgets.LoginTitle
import com.sukaidev.mine.R
import com.sukaidev.mine.data.entity.UserInfo
import com.sukaidev.mine.injection.component.DaggerUserComponent
import com.sukaidev.mine.injection.module.UserModule
import com.sukaidev.mine.presenter.LoginPresenter
import com.sukaidev.mine.presenter.view.LoginView
import com.sukaidev.mine.utils.UserPrefsUtils
import com.sukaidev.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.input_login_layout.*

import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * Created by sukaidev on 2019/07/30.
 *
 */
@Route(path = RouterPath.MineModule.LOGIN_PATH)
class LoginActivity : AppMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    private var mForgetPwdBtn: TextView? = null

    private lateinit var mTitleLayout: LoginTitle

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    /**
     * 初始化视图
     */
    override fun initView() {
        mLoginLayout.setBackgroundResource(R.drawable.login_bg)
        mTitleLayout = find(R.id.mTitleLayout)
        mForgetPwdBtn = find(R.id.mForgetPwdBtn)
        mForgetPwdBtn!!.paint.isAntiAlias = true
        mForgetPwdBtn!!.paint.flags = Paint.UNDERLINE_TEXT_FLAG

        // 登录
        mLoginBtn.onClick(this)
        // 注册
        mTitleLayout.getSignInBtn().onClick(this)
//        mTitleLayout.mSignInBtn.onClick(this)
        // 忘记密码
        mForgetPwdBtn!!.onClick(this)
    }

    /**
     * 初始化数据
     */
    override fun initData() {

    }


    /**
     * 登录回调，保存用户信息，返回首页，实现LoginView
     */
    override fun loginResult(result: UserInfo) {
        toast("登录成功")
        //保存用户信息
        UserPrefsUtils.putUserInfo(result)
        finish()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mSignInBtn -> {
                startTop<RegisterActivity>()
            }
            R.id.mForgetPwdBtn -> {
                toast("忘记密码")
            }
            R.id.mLoginBackBtn -> {
                if (mUserNameEt.text.toString() == "" || mPwdEt.text.toString() == "") {
                    AlerterUtils.error(this, "消息通知", "用户名或密码不能为空！")
                    return
                }
                /**
                 * 登录方法
                 */
                mPresenter.login(mUserNameEt.text.toString(), mPwdEt.text.toString())
            }
        }
    }

    /**
     * 点击back键关闭页面
     */
    override fun onBackPressed() {
        AppManager.instance.finishActivity(this)
    }
}