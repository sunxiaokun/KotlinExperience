package com.trace.reportsystem.fragment

import android.os.Bundle
import com.trace.kotlinexperience.R
import kotlinx.android.synthetic.main.fragment_home.*

class TransactionFragment : BaseFragment() {
    override fun initialize(savedInstanceState: Bundle?) {
        fragment_tv.text = "transaction"
    }

    override fun isBindEventBus(): Boolean {
        return false
    }

    override fun getContentViewID(): Int {
        return R.layout.fragment_home
    }

}