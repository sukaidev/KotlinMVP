package com.sukaidev.common.presenter.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.sukaidev.common.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * Created by sukaidev on 2019/07/27.
 *
 */

abstract class AppActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        AppManager.instance.addActivity(this)
        setContentView(layoutId())
        initView()
    }

    override fun onStart() {
        super.onStart()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

    /**
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()
}