package com.sukaidev.common.presenter.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle.components.support.RxFragment

/**
 * Created by sukaidev on 2019/07/28.
 *
 */
abstract class AppFragment : RxFragment() {

    var mTitle: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(getFragmentId(), null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        initData()
    }

    /**
     * 获取资源Id
     */
    abstract fun getFragmentId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()

    /**
     * 获取Activity
     */
    abstract fun mActivity(): Activity
}