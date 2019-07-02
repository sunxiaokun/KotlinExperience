package com.trace.kotlinexperience.layout

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class NoScrollViewPager : ViewPager {

    var isScroll: Boolean = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet)
            : super(context, attributeSet)


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (isScroll) {
            super.onInterceptTouchEvent(ev)
        } else {
            false
        }
    }


    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (isScroll) {
            super.onTouchEvent(ev)
        } else
            true
    }


}