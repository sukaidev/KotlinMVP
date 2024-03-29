package com.sukaidev.common.widgets

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.sukaidev.common.R
import com.sukaidev.common.ext.onClick
import kotlinx.android.synthetic.main.title_layout.view.*

/**
 * Created by sukaidev on 2019/07/29.
 */
class LoginTitle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr) {

    private var mSignInBtnText:String? = null

    init {
        //获取自定义属性
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.loginTitle)
        mSignInBtnText = typedArray.getString(R.styleable.loginTitle_mSignInBtn)

        initView()
        typedArray.recycle()

    }
    private fun initView() {
        View.inflate(context, R.layout.title_layout,this)
        mSignInBtnText?.let {
            mSignInBtn.text = it
        }

        mLoginBackBtn.onClick {
            if (context is Activity){
                (context as Activity).finish()
            }
        }
    }

    fun getSignInBtn():TextView{
        return mSignInBtn
    }

    fun getSignBtnText():String{
        return mSignInBtn.text.toString()
    }
}