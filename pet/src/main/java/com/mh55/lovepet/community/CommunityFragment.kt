package com.mh55.lovepet.community

import android.view.View
import com.google.android.material.button.MaterialButton
import com.mh55.easymvvm.ext.singleClick
import com.mh55.easymvvm.ui.fragment.BaseFragment
import com.mh55.easymvvm.ui.loadsir.LoadSirDefaultNetCallback
import com.mh55.lovepet.BR
import com.mh55.lovepet.R
import com.mh55.lovepet.databinding.FragmentCommunityBinding
import com.mh55.lovepet.databinding.FragmentMessageBinding
import com.mh55.lovepet.databinding.FragmentMineBinding
import com.mh55.lovepet.http.vm.CommunityViewModel
import com.mh55.lovepet.http.vm.MessageViewModel
import com.mh55.lovepet.http.vm.MineViewModel

/**
 * 公司名称：~漫漫人生路~总得错几步~
 * 创建作者：Android 孟从伦
 * 创建时间：2022/10/15
 * 功能描述： 消息
 */

class CommunityFragment : BaseFragment<FragmentCommunityBinding,CommunityViewModel>(R.layout.fragment_community,BR.viewModel) {
    companion object {
        @JvmStatic
        fun newInstance() = CommunityFragment()
    }

    override fun initData() {
        super.initData()
//        mBinding.net.singleClick {
//            showCallback(LoadSirDefaultNetCallback::class.java){_,view->
//                view.findViewById<MaterialButton>(R.id.btn_net_refresh).singleClick {
//                    showLoading()
//                    it.postDelayed({
//                        dismissLoading()
//                        dismissCallback()
//                    },2*1000)
//
//                }
//            }
//        }
    }

    override fun getLoadSirView(): View? {
        return mBinding.loadingView
    }
}