package com.mh55.lovepet.http.vm

import androidx.lifecycle.LifecycleOwner
import com.google.android.material.button.MaterialButton
import com.mh55.easymvvm.ext.singleClick
import com.mh55.easymvvm.mvvm.BaseViewModel
import com.mh55.easymvvm.ui.loadsir.LoadSirDefaultNetCallback
import com.mh55.lovepet.R

class CommunityViewModel : BaseViewModel() {



    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        showCallback(LoadSirDefaultNetCallback::class.java){_,view->
            view.findViewById<MaterialButton>(R.id.btn_net_refresh).singleClick {
                it.postDelayed({
                    dismissCallback()
                },2*1000)

            }
        }
    }
}