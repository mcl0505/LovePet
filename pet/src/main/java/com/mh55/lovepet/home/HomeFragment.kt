package com.mh55.lovepet.home

import androidx.fragment.app.Fragment
import com.mh55.easymvvm.ui.fragment.BaseFragment
import com.mh55.lovepet.BR
import com.mh55.lovepet.R
import com.mh55.lovepet.databinding.FragmentHomeBinding
import com.mh55.lovepet.http.vm.HomeViewModel

/**
 * 公司名称：~漫漫人生路~总得错几步~
 * 创建作者：Android 孟从伦
 * 创建时间：2022/10/15
 * 功能描述：首页
 */

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home,BR.viewModel) {

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}