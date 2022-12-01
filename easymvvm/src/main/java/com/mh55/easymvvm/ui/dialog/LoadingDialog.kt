package com.mh55.easymvvm.ui.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.mh55.easymvvm.R

/**
 * 加载等待框
 */
class LoadingDialog(context: Context,msg:CharSequence) : Dialog(
    context,
    R.style.LoadingDialog
){
    private var loadingDialog: LoadingDialog? = null

    init {
        setContentView(R.layout.layout_loading_view)
        val imageView: ImageView = findViewById(R.id.iv_image)
        val textView: TextView = findViewById(R.id.message)
        val animation: Animation = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animation.duration = 2000
        animation.repeatCount = 10
        animation.fillAfter = true
        imageView.startAnimation(animation)
        textView.text = msg
    }

    fun showDialog(context: Context,msg: CharSequence = "加载中") {
        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }

        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(context,msg)
        }
        loadingDialog?.show()
    }

    fun dismissDialog() {
        loadingDialog?.dismiss()
    }
}