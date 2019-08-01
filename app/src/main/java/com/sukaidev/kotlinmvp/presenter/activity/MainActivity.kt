package com.sukaidev.kotlinmvp.presenter.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.flyco.tablayout.widget.MsgView
import com.google.android.material.navigation.NavigationView
import com.sukaidev.common.common.AppManager
import com.sukaidev.common.ext.onClick
import com.sukaidev.common.presenter.activity.AppMvpActivity
import com.sukaidev.kotlinmvp.R
import com.sukaidev.kotlinmvp.data.entity.TabEntity
import com.sukaidev.kotlinmvp.injection.component.DaggerMainComponent
import com.sukaidev.kotlinmvp.injection.module.MainModule
import com.sukaidev.kotlinmvp.presenter.MainPresenter
import com.sukaidev.kotlinmvp.presenter.fragment.DiscoveryFragment
import com.sukaidev.kotlinmvp.presenter.fragment.HomeFragment
import com.sukaidev.kotlinmvp.presenter.fragment.MineFragment
import com.sukaidev.kotlinmvp.presenter.fragment.NotifyFragment
import com.sukaidev.kotlinmvp.presenter.view.MainView
import com.sukaidev.provider.common.afterLogin
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppMvpActivity<MainPresenter>(), MainView, View.OnClickListener {

    //侧边栏头像点击
    private lateinit var headerLayout: View

    //主界面Fragment
    private var mHomeFragment: HomeFragment? = null

    //"发现"Fragment
    private var mDiscoveryFragment: DiscoveryFragment? = null

    private var mNotifyFragment: NotifyFragment? = null

    //"我的"Fragment
    private var mMineFragment: MineFragment? = null

    private val mTitles = arrayOf("首页", "发现", "消息", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(
        R.mipmap.ic_home_normal,
        R.mipmap.ic_discovery_normal,
        R.mipmap.ic_hot_normal,
        R.mipmap.ic_mine_normal
    )
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(
        R.mipmap.ic_home_selected,
        R.mipmap.ic_discovery_selected,
        R.mipmap.ic_hot_selected,
        R.mipmap.ic_mine_selected
    )

    private lateinit var toolBar: Toolbar

    private val mTabEntities = ArrayList<CustomTabEntity>()

    //默认为0
    private var mIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
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
        //初始化ToolBar和侧拉菜单
        initToolBar()
        //初始化底部菜单
        initTab()
        tab_layout.currentTab = mIndex

        switchFragment(mIndex)
        headerLayout = mNavigationView.getHeaderView(0)
        val userNameBtn = headerLayout.find<TextView>(R.id.mUsername)
        userNameBtn.onClick(this)
        val userAvatarBtn = headerLayout.find<CircleImageView>(R.id.mAvatar)
        userAvatarBtn.onClick(this)
    }

    private fun initToolBar() {

        //mNavigationView.setCheckedItem(R.id.nav_call)

        mNavigationView.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                //mDrawerLayout.closeDrawers()
                return true
            }
        })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mAvatar, R.id.mUsername -> {
                afterLogin {
                    toast("没有登录，前去登录页")
                }
            }
            else -> {
            }
        }
    }

    private fun initTab() {
        (0 until mTitles.size).mapTo(mTabEntities)
        { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }

        tab_layout.setTabData(mTabEntities)
        //设置未读消息红点
        tab_layout.showDot(1)
        //设置未读消息背景
        tab_layout.showMsg(2, 5)
        tab_layout.setMsgMargin(3, 0f, 5f)
        val rtv_2_3 = tab_layout.getMsgView(3) as MsgView
        rtv_2_3.backgroundColor = Color.parseColor("#6D8FB0")

        //选中监听
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)

        when (position) {
            // 首页
            0 -> {
                mHomeFragment?.let {
                    transaction.show(it)
                } ?: HomeFragment.getInstance(mTitles[position]).let {
                    mHomeFragment = it
                    transaction.add(R.id.fl_container, it, "home")
                }
            }
            //发现
            1 -> mDiscoveryFragment?.let {
                transaction.show(it)
            } ?: DiscoveryFragment.getInstance(mTitles[position]).let {
                mDiscoveryFragment = it
                transaction.add(R.id.fl_container, it, "discovery")
            }
            //消息
            2 -> mNotifyFragment?.let {
                transaction.show(it)
            } ?: NotifyFragment.getInstance(mTitles[position]).let {
                mNotifyFragment = it
                transaction.add(R.id.fl_container, it, "notify")
            }
            //我的
            3 -> {
                mMineFragment?.let {
                    transaction.show(it)
                } ?: MineFragment.getInstance(mTitles[position]).let {
                    mMineFragment = it
                    transaction.add(R.id.fl_container, it, "mine")
                }
            }
            else -> {

            }
        }
        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()

    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mDiscoveryFragment?.let { transaction.hide(it) }
        mNotifyFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun injectComponent() {
        DaggerMainComponent.builder()
            .activityComponent(activityComponent)
            .mainModule(MainModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }


    private var pressTime: Long = 0

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出程序")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }

    }
}
