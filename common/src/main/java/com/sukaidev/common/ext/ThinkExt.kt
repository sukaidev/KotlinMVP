package com.sukaidev.common.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.sukaidev.common.http.entity.Think
import com.sukaidev.common.rx.BaseConvert
import com.sukaidev.common.rx.BaseConvertBool
import com.sukaidev.common.rx.BaseSubscriber
import com.sukaidev.common.utils.GlideUtils
import com.sukaidev.common.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by sukaidev on 2019/07/29.
 * 扩展方法.
 */


/**
 * 扩展点击事件
 */
fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

/**
 * 函数式扩展
 */
fun View.onClick(method: () -> Unit) {
    this.setOnClickListener {
        method()
    }
}

/**
 * 扩展页面跳转
 */
inline fun <reified T> Activity.start() {
    this.startActivity(Intent(this, T::class.java))
}

/**
 * activity制定
 */
inline fun <reified activity : Activity> Activity.startTop() {
    this.startActivity(intentFor<activity>().singleTop().clearTop())
}

/**
 * 通用数据转换
 */
fun <T> Observable<Think<T>>.convert(): rx.Observable<T> {
    return this.flatMap(BaseConvert())
}

/**
 * bool值转换
 */
fun <T> Observable<Think<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseConvertBool())
}

/**
 * 扩展Observable执行
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    //监听主线程
    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        //订阅
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)

}

/**
 * 获取颜色
 */
infix fun Context.takeColor(colorId: Int) = ContextCompat.getColor(this, colorId)

/*
 * 扩展Button可用性
 */
fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/**
 * ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

/**
 * 扩展视图可见性
 */
fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}