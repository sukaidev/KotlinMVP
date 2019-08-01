package com.sukaidev.mine.presenter.activity

import android.view.View
import com.sukaidev.common.ext.onClick
import com.sukaidev.common.ext.startTop
import com.sukaidev.common.presenter.activity.AppMvpActivity
import com.sukaidev.common.utils.AlerterUtils
import com.sukaidev.mine.R
import com.sukaidev.mine.presenter.RegisterPresenter
import com.sukaidev.mine.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.input_register_layout.*
import org.jetbrains.anko.toast

/**
 * Created by sukaidev on 2019/08/01.
 *
 */
class RegisterActivity : AppMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {
    override fun injectComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun layoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView() {
        mRegisterLayout.setBackgroundResource(R.drawable.login_bg)
        mMainTitle.getSignInBtn().onClick(this)
        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }
            R.id.mSignInBtn -> {
                finish()
            }
            R.id.mRegisterBtn -> {
                if (mVerifyCodeEt.text.toString() == "") {
                    AlerterUtils.error(this, "消息通知", "验证码不能为空！")
                }
                if (mPwdEt.text.toString() == "" || mRePwdEt.text.toString() == "") {
                    AlerterUtils.error(this, "消息通知", "密码不能为空！")
                }
                if (mPwdEt.text.toString() != mRePwdEt.text.toString()) {
                    AlerterUtils.warn(this, "消息通知", "密码与确认密码不一致！")
                }
                mPresenter.register(
                    mUserNameEt.text.toString(), mPwdEt.text.toString(),
                    mVerifyCodeEt.text.toString()
                )
            }
        }
    }

    override fun onRegisterResult(result: String) {
        toast("注册成功")
        startTop<LoginActivity>()
    }
}