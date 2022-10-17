package com.mh55.easymvvm.ext

import android.os.SystemClock
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import com.mh55.easymvvm.R

private var lastClickTime: Long = 0
//防止快速点击造成打开多个界面   只允许在 1秒内只能点击一次  single(2000){}   可自定义时间
/**
 * 防止快速点击造成打开多个界面
 */
fun <T : View> T.singleClick(time: Int = 500, block: (T) -> Unit) {
    this.setOnClickListener {
        val curClickTime = SystemClock.uptimeMillis()
        val lastClickTime = (it.getTag(R.id.singleClickId) as? Long) ?: 0
        // 超过点击间隔后再将lastClickTime重置为当前点击时间
        it.setTag(R.id.singleClickId, lastClickTime)
        if (curClickTime - lastClickTime >= time) {
            block(it as T)
        }
    }
}


/**
 * view 显示隐藏
 */
fun View.visibleOrGone(show: Boolean) {
    if (show) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

/**
 * view 显示与占位
 */
fun View.visibleOrInvisible(show: Boolean) {
    if (show) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.INVISIBLE
    }
}

/**
 *  getDominantColor：获取图片中的主色调
getMutedColor：获取图片中柔和的颜色
getDarkMutedColor：获取图片中柔和的暗色
getLightMutedColor：获取图片中柔和的亮色
getVibrantColor：获取图片中有活力的颜色
getDarkVibrantColor：获取图片中有活力的暗色
getLightVibrantColor：获取图片中有活力的亮色
 */
fun ImageView.getPaletteColor(): Palette {
    val mBitmap = this.drawable.toBitmap()
    val builder = Palette.from(mBitmap).generate()
    return builder
}