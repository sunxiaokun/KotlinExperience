package com.trace.kotlinexperience.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import com.trace.kotlinexperience.R
import com.trace.reportsystem.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_main_icon.view.*


class MainActivity : AppCompatActivity() {

    private var homePagerFragment: BaseFragment = HomePagerFragment()
    private var transactionFragment: BaseFragment = TransactionFragment()
    private var taskFragment: BaseFragment = TaskFragment()
    private var mineFragment: BaseFragment = MineFragment()

    private val list: List<BaseFragment> = listOf(homePagerFragment,
            transactionFragment, taskFragment, mineFragment)

    private val titles = listOf("首页", "项目", "工作", "我的")
    private val select = listOf(R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round)

    private val unselect = listOf(R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        main_vp.adapter = MyViewPagerAdapter(supportFragmentManager, list)

        setCustomIcon()

        main_tl.addOnTabSelectedListener(object : TabLayout.ViewPagerOnTabSelectedListener(main_vp) {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                super.onTabSelected(tab)

                var position: Int = tab!!.position
                uploadView(tab.customView!!, titles[position], select[position],
                        resources.getColor(R.color.colorAccent))

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                super.onTabUnselected(tab)

                var position: Int = tab!!.position
                uploadView(tab.customView!!, titles[position], unselect[position],
                        resources.getColor(R.color.colorPrimary))
            }

        })
    }

    private fun setCustomIcon() {
        for (i in 0 until titles.size) {
            main_tl.addTab(main_tl.newTab().setCustomView(makeTabView(titles[i],
                    if (i == 1) select[i] else unselect[i],
                    if (i == 1) resources.getColor(R.color.colorAccent)
                    else resources.getColor(R.color.colorPrimary))),
                    i == 1)

        }

    }

    private fun makeTabView(title: String, imgId: Int, colorId: Int): View? {
        val tabView = LayoutInflater.from(this).inflate(R.layout.layout_main_icon, null)
        uploadView(tabView, title, imgId, colorId)
        return tabView
    }


    private fun uploadView(tabView: View, title: String, imgId: Int, colorId: Int) {
        tabView.textview?.text = title
        tabView.textview?.setTextColor(colorId)
        tabView.imageview?.setImageResource(imgId)
    }

    class MyViewPagerAdapter(fm: FragmentManager?, var list: List<BaseFragment>) : FragmentPagerAdapter(fm) {
        override fun getItem(p: Int): Fragment {
            return list[p]
        }

        override fun getCount(): Int {
            return list.size
        }

    }

}
