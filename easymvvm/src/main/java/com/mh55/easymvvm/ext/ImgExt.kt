package com.mh55.easymvvm.ext

import android.graphics.drawable.Drawable
import android.widget.ImageView
import coil.imageLoader
import coil.load
import coil.loadAny
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.mh55.easymvvm.App.ConfigBuilder
import com.mh55.easymvvm.EasyApplication
import com.mh55.easymvvm.R
import org.jetbrains.anko.image

/**
 *   公司名称: ~漫漫人生路~总得错几步~
 *   创建作者: Android 孟从伦
 *   创建时间: 2022/10/18
 *   功能描述:
 *
 *   图片加载   Coil + ShapeableImageView
 *   Coil:加载普通图片与圆形图片
 *   ShapeableImageView：添加不同的圆角 配合Coil 使用
 */

/**
 * 加载普通图片
 * @param url  必选  可为空
 * @param imageView  图片展示控件  如果不传，则加载的结果在block() 中展示
 * @param block  图加载结果回调  仅imageView 为null 时生效
 */
fun displayImage(url: Any?,imageView: ImageView?=null,block:(drawable:Drawable)->Unit = {}){
    if (imageView == null){
        val request = ImageRequest.Builder(EasyApplication.getContext())
            .data(url)
            .placeholder(ConfigBuilder.mImagePlaceholder)
            .error(ConfigBuilder.mImagePlaceholder)
            .target {
                block.invoke(it)
            }
            .build()
        EasyApplication.getContext().imageLoader.enqueue(request)
    }else {
        imageView.loadAny(url){
            placeholder(ConfigBuilder.mImagePlaceholder)
            error(ConfigBuilder.mImagePlaceholder)
        }
    }
}

/**
 * 加载圆形图片
 * @param url  必选  可为空
 * @param imageView  图片展示控件  如果不传，则加载的结果在block() 中展示
 * @param block  图加载结果回调  仅imageView 为null 时生效
 */
fun displayImageRound(url: Any?,imageView: ImageView?=null,block:(drawable:Drawable)->Unit = {}){
    if (imageView == null){
        val request = ImageRequest.Builder(EasyApplication.getContext())
            .data(url)
            .placeholder(ConfigBuilder.mImagePlaceholder)
            .error(ConfigBuilder.mImagePlaceholder)
            .target {
                block.invoke(it)
            }
            .build()
        EasyApplication.getContext().imageLoader.enqueue(request)
    }else {
        imageView.loadAny(url){
            placeholder(ConfigBuilder.mImagePlaceholder)
            error(ConfigBuilder.mImagePlaceholder)
            transformations(CircleCropTransformation())
        }
    }
}
