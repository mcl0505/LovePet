package com.mh55.lovepet.main

import androidx.core.view.children
import com.mh55.easymvvm.ext.singleClick
import com.mh55.easymvvm.ui.activity.BaseActivity
import com.mh55.easymvvm.widget.tab.withViewPager
import com.mh55.lovepet.BR
import com.mh55.lovepet.R
import com.mh55.lovepet.community.CommunityFragment
import com.mh55.lovepet.databinding.ActivityMainBinding
import com.mh55.lovepet.home.HomeFragment
import com.mh55.lovepet.http.vm.MainViewModel
import com.mh55.lovepet.message.MessageFragment
import com.mh55.lovepet.mine.MineFragment
import com.mh55.lovepet.utils.animator.MainPushAnimator

/**
 * 公司名称：~漫漫人生路~总得错几步~
 * 创建作者：Android 孟从伦
 * 创建时间：2022/10/15
 * 功能描述： 主页
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main,
    BR.viewModel
) {

    override fun initData() {
        super.initData()
        mBinding.mTabButtonGroup.withViewPager(this,mBinding.mViewPager, mutableListOf(
            HomeFragment.newInstance(),//首页
            CommunityFragment.newInstance(),//社区
            PushFragment.newInstance(),//发布
            MessageFragment.newInstance(),//消息
            MineFragment.newInstance()//个人中心
        ))
        mBinding.mTabButtonGroup.onTabSelectClick={
            MainPushAnimator.hindMenu(mBinding.mPush,mBinding.mArcLayout)
        }
        mBinding.mPush.singleClick {
//            if (it.isSelected){
//                MainPushAnimator.hindMenu(it,mBinding.mArcLayout)
//            }else MainPushAnimator.showMenu(it,mBinding.mArcLayout)

            showLoading()
            it.postDelayed({
                dismissLoading()
            },10*1000)
        }
        //点击菜单
        mBinding.mArcLayout.children.forEach {
            it.singleClick {
                MainPushAnimator.hindMenu(mBinding.mPush,mBinding.mArcLayout)
            }
        }
        mBinding.mArcLayout.singleClick {
            MainPushAnimator.hindMenu(mBinding.mPush,mBinding.mArcLayout)
        }

    }
}