package com.mh55.lovepet.message

import com.mh55.easymvvm.ui.fragment.BaseFragment
import com.mh55.lovepet.BR
import com.mh55.lovepet.R
import com.mh55.lovepet.databinding.FragmentMessageBinding
import com.mh55.lovepet.databinding.FragmentMineBinding
import com.mh55.lovepet.http.vm.MessageViewModel
import com.mh55.lovepet.http.vm.MineViewModel

/**
 * 公司名称：~漫漫人生路~总得错几步~
 * 创建作者：Android 孟从伦
 * 创建时间：2022/10/15
 * 功能描述： 消息
 */

class MessageFragment : BaseFragment<FragmentMessageBinding,MessageViewModel>(R.layout.fragment_message,BR.viewModel) {
    companion object {
        @JvmStatic
        fun newInstance() = MessageFragment()
    }
}