package com.mh55.lovepet.utils.animator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.OvershootInterpolator
import com.mh55.easymvvm.ext.visibleOrInvisible
import com.ogaclejapan.arclayout.ArcLayout

object MainPushAnimator {

    fun hindMenu(pushBtn:View,mMenu: ArcLayout){
        pushBtn.isSelected = false
        val animList: MutableList<Animator?> = ArrayList()
        for (i in mMenu.getChildCount() - 1 downTo 0) {
            animList.add(createHideItemAnimator(pushBtn,mMenu.getChildAt(i)))
        }
        val animSet = AnimatorSet()
        animSet.duration = 400
        animSet.interpolator = AnticipateInterpolator()
        animSet.playTogether(animList)
        animSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                mMenu.visibleOrInvisible(false)
            }
        })
        animSet.start()
    }

    fun showMenu(pushBtn:View,mMenu: ArcLayout){
        pushBtn.isSelected = true
        mMenu.visibleOrInvisible(true)
        val animList: MutableList<Animator?> = ArrayList()
        var i = 0
        val len: Int = mMenu.getChildCount()
        while (i < len) {
            animList.add(createShowItemAnimator(pushBtn,mMenu.getChildAt(i)))
            i++
        }
        val animSet = AnimatorSet()
        animSet.duration = 400
        animSet.interpolator = OvershootInterpolator()
        animSet.playTogether(animList)
        animSet.start()
    }

    fun createShowItemAnimator(rootView: View, item: View): Animator? {
        val dx: Float = rootView.getX() - item.getX()
        val dy: Float = rootView.getY() - item.getY()
        item.setRotation(0f)
        item.setTranslationX(dx)
        item.setTranslationY(dy)
        return ObjectAnimator.ofPropertyValuesHolder(
            item,
            AnimatorUtils.rotation(0f, 720f),
            AnimatorUtils.translationX(dx, 0f),
            AnimatorUtils.translationY(dy, 0f)
        )
    }

    fun createHideItemAnimator(rootView: View,item: View): Animator? {
        val dx: Float = rootView.getX() - item.getX()
        val dy: Float = rootView.getY() - item.getY()
        val anim: Animator = ObjectAnimator.ofPropertyValuesHolder(
            item,
            AnimatorUtils.rotation(720f, 0f),
            AnimatorUtils.translationX(0f, dx),
            AnimatorUtils.translationY(0f, dy)
        )
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                item.setTranslationX(0f)
                item.setTranslationY(0f)
            }
        })
        return anim
    }

}