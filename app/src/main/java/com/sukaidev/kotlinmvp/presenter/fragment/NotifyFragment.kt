package com.sukaidev.kotlinmvp.presenter.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.sukaidev.common.presenter.fragment.AppFragment
import com.sukaidev.kotlinmvp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_notify.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by sukaidev on 2019/08/01.
 *
 */
class NotifyFragment : AppFragment() {

    override fun mActivity(): Activity {
        return activity?.let {
            return it
        } as Activity
    }

    override fun getFragmentId(): Int {
        return R.layout.fragment_notify
    }

    companion object {
        fun getInstance(title: String): NotifyFragment {
            val fragment = NotifyFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * 初始化数据
     */
    override fun initData() {

    }

    /**
     * 初始化视图
     */
    override fun initView() {
        initToolBar()
    }

    /**
     * 初始化ToolBar
     */
    private fun initToolBar() {
        //设置标题
        mAppToolBar.setTitle("消息")
        //展开侧边栏
        mAppToolBar.onClickMineInfoListen {
            mActivity().mDrawerLayout.openDrawer(GravityCompat.START)
        }
        //隐藏右侧icon按钮
        mAppToolBar.setIcon1Visible(View.VISIBLE)
        mAppToolBar.onClickIcon1Listen { toast("click 1") }
    }
}