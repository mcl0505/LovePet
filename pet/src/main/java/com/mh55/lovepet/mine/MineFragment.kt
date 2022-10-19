package com.mh55.lovepet.mine

import android.view.Gravity
import com.google.android.material.appbar.AppBarLayout
import com.mh55.easymvvm.dsl.setShapeDrawable
import com.mh55.easymvvm.ext.displayImageRound
import com.mh55.easymvvm.ext.dp2px
import com.mh55.easymvvm.ext.getColor
import com.mh55.easymvvm.ext.getPaletteColor
import com.mh55.easymvvm.ext.singleClick
import com.mh55.easymvvm.ext.toast
import com.mh55.easymvvm.ui.fragment.BaseFragment
import com.mh55.easymvvm.utils.StatusBarUtils
import com.mh55.lovepet.BR
import com.mh55.lovepet.R
import com.mh55.lovepet.databinding.FragmentMineBinding
import com.mh55.lovepet.http.vm.MineViewModel

/**
 * 公司名称：~漫漫人生路~总得错几步~
 * 创建作者：Android 孟从伦
 * 创建时间：2022/10/15
 * 功能描述： 个人中心
 */

class MineFragment : BaseFragment<FragmentMineBinding, MineViewModel>(R.layout.fragment_mine, BR.viewModel) {
    companion object {
        @JvmStatic
        fun newInstance() = MineFragment()
    }

    override fun initData() {
        super.initData()
        initToolBar()
        displayImageRound(R.mipmap.cat, mBinding.mAvatar)
        mBinding.apply {
            mTopBg.singleClick {
                "点击更换背景".toast()
            }
            mineOut.singleClick {
                "退出登录".toast()
            }
        }
        initPallet()
    }

    private fun initPallet() {
        getPaletteColor(R.mipmap.img_cat_bg_2) { mPalette->
            mBinding.apply {
                mPetTime.setShapeDrawable {
                    shape {
                        addSolidColor(mPalette.getLightVibrantColor(R.color.white.getColor()))
                        addCornerSize(2f)
                    }
                }

                mineOut.setShapeDrawable {
                    shape {
                        addSolidColor(mPalette.getLightVibrantColor(R.color.white.getColor()))
                        addCornerSize(5f)
                    }
                }

                mCollapsing.apply {
                    //设置AppBarLayout 完全收缩之后的标题颜色
                    setCollapsedTitleTextColor(mPalette.vibrantSwatch?.bodyTextColor!!)
                    //设置展开后标题的位置
                    //expandedTitleGravity = Gravity.CENTER
                    //设置AppBarLayout 完全展开之后的标题颜色
                    setExpandedTitleColor(mPalette.vibrantSwatch?.titleTextColor!!)
                    //设置AppBarLayout 完全收缩之后  ToolBar 的背景色
                    setContentScrimColor(mPalette.getLightVibrantColor(R.color.white.getColor()))
                }
            }
        }
    }

    private fun initToolBar() {
        mBinding.mToolBar.apply {
            setPadding(0, StatusBarUtils.getStatusBarHeight(mActivity), 0, 0)
            layoutParams.height = mContext.dp2px(50) + StatusBarUtils.getStatusBarHeight(mContext)
            //修改标题名称
            title = "梦虍"
        }
        //设置收缩后标题的位置
        mBinding.mCollapsing.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL

        mBinding.mAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val totalScrollRange = appBarLayout!!.totalScrollRange.toFloat()
            val rate = -1 * verticalOffset / totalScrollRange

            // 设置 toolbar 背景
            if (verticalOffset > -totalScrollRange) {
                StatusBarUtils.setStateBarTextColor(mActivity, true)
            } else {
                StatusBarUtils.setStateBarTextColor(mActivity, false)
            }
        })

    }

}