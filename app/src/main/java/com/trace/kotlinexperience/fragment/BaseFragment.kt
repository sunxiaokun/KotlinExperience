package com.trace.reportsystem.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment(){
    private val mIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if(getContentViewID() != 0)
            inflater.inflate(getContentViewID(),null)
        else
            super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.isClickable = true
        initialize(savedInstanceState)
    }


    abstract fun isBindEventBus(): Boolean
    abstract fun getContentViewID(): Int
    abstract fun initialize(savedInstanceState: Bundle?)


}