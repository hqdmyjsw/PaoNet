package com.ditclear.paonet.di.module

import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import dagger.Module
import dagger.Provides

/**
 * 页面描述：app
 *
 * Created by ditclear on 2017/9/26.
 */
@Module
class ActivityModule(val activity: RxAppCompatActivity){

    @Provides
    fun provideActivity():RxAppCompatActivity=activity

    @Provides
    fun provideLifeCycle(): LifecycleTransformer<Any> = activity.bindToLifecycle()
}