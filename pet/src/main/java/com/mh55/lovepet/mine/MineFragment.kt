package com.mh55.lovepet.mine

import com.mh55.easymvvm.ui.fragment.BaseFragment
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

class MineFragment : BaseFragment<FragmentMineBinding,MineViewModel>(R.layout.fragment_mine,BR.viewModel) {
    companion object {
        @JvmStatic
        fun newInstance() = MineFragment()
    }
}