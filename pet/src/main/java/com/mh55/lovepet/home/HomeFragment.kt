package com.mh55.lovepet.home

import android.graphics.drawable.GradientDrawable
import com.mh55.easymvvm.dsl.setShapeDrawable
import com.mh55.easymvvm.ext.displayImage
import com.mh55.easymvvm.ext.displayImageRadius
import com.mh55.easymvvm.ext.getColor
import com.mh55.easymvvm.ext.getPaletteColor
import com.mh55.easymvvm.ext.toDp
import com.mh55.easymvvm.ui.fragment.BaseFragment
import com.mh55.easymvvm.utils.LogUtil
import com.mh55.lovepet.BR
import com.mh55.lovepet.R
import com.mh55.lovepet.databinding.FragmentHomeBinding
import com.mh55.lovepet.http.vm.HomeViewModel
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.listener.OnPageChangeListener
import org.jetbrains.anko.image
import org.jetbrains.anko.support.v4.runOnUiThread

/**
 * 公司名称：~漫漫人生路~总得错几步~
 * 创建作者：Android 孟从伦
 * 创建时间：2022/10/15
 * 功能描述：首页
 */

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home, BR.viewModel) {

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
    var isInit = true
    val bannerList = listOf(R.mipmap.img_cat_bg,R.mipmap.img_cat_bg_2,R.mipmap.img_cat_bg_3)
    override fun initData() {
        super.initData()
        mBinding.mHomeSearch.apply {
            setShapeDrawable {
                shape {
                    addCornerSize(20f)
                    addSolidColor(R.color.color_c0c0c8.getColor())
                }
            }
        }

        getPaletteColor(bannerList[0]){mPalette->
            val startColor = mPalette.getLightVibrantColor(R.color.color_white.getColor())
            val endColor = mPalette.getLightMutedColor(R.color.color_white.getColor())
            mBinding.homeTopBg.setShapeDrawable {
                shape {
                    addCornerRadii(floatArrayOf(0f,0f,0f,0f,12f.toDp(),12f.toDp(),12f.toDp(),12f.toDp()))
                    addGradient(intArrayOf(startColor,endColor),gradientType= GradientDrawable.Orientation.TOP_BOTTOM)
                }

            }
        }

        mBinding.mBanner.apply {
            addBannerLifecycleObserver(this@HomeFragment)
            setBannerGalleryEffect(40,12)
            adapter = object : BannerImageAdapter<Int>(bannerList){
                override fun onBindView(holder: BannerImageHolder?, data: Int?, position: Int, size: Int) {
                    displayImageRadius(data,holder?.imageView,6f.toDp())
                }
            }
            addOnPageChangeListener(object : OnPageChangeListener{
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    if (positionOffset>1)return
//                    displayImage(bannerList[position], block = {
//                        LogUtil.d("drawable=$it")
//                        LogUtil.d("PaletteColor=${it.getPaletteColor()}")
//                        val startColor = it.getPaletteColor().getLightVibrantColor(R.color.color_white.getColor())
//                        val endColor = it.getPaletteColor().getLightMutedColor(R.color.color_white.getColor())
//                        runOnUiThread {
//                            mBinding.homeTopBg.setShapeDrawable {
//                                shape {
//                                    addCornerRadii(floatArrayOf(0f,0f,0f,0f,12f.toDp(),12f.toDp(),12f.toDp(),12f.toDp()))
//                                    addGradient(intArrayOf(startColor,endColor),gradientType= GradientDrawable.Orientation.TOP_BOTTOM)
//                                    LogUtil.d("position=$position")
//                                }
//
//                            }
//                        }
//
//
//                    })
                }

                override fun onPageSelected(position: Int) {
                    getPaletteColor(bannerList[position]){ mPalette->
                        val startColor = mPalette.getLightVibrantColor(R.color.color_white.getColor())
                        val endColor = R.color.color_transparent.getColor()
                        mBinding.homeTopBg.setShapeDrawable {
                            shape {
                                addCornerRadii(floatArrayOf(0f,0f,0f,0f,12f.toDp(),12f.toDp(),12f.toDp(),12f.toDp()))
                                addGradient(intArrayOf(startColor,endColor),gradientType= GradientDrawable.Orientation.TOP_BOTTOM)
                            }

                        }
                    }

                }

                override fun onPageScrollStateChanged(state: Int) {

                }

            })
        }
    }

    override fun onPause() {
        super.onPause()
        mBinding.mBanner.stop()
    }

    override fun onResume() {
        super.onResume()
        mBinding.mBanner.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding.mBanner.destroy()
    }
}