package com.ditclear.paonet.view.search

import android.content.Context
import android.os.Bundle
import com.ditclear.paonet.R
import com.ditclear.paonet.databinding.ContentMainBinding
import com.ditclear.paonet.lib.adapter.viewpager.AbstractPagerAdapter
import com.ditclear.paonet.view.BaseFragment
import com.ditclear.paonet.view.helper.Constants
import javax.inject.Inject
import javax.inject.Named

/**
 * 页面描述：SearchResultFragment
 *
 * Created by ditclear on 2017/10/24.
 */
class SearchResultFragment : BaseFragment<ContentMainBinding>() {

    override fun getLayoutId() = R.layout.content_main

    lateinit var keyWord :String

    @Inject
    @field:Named(Constants.Qualifier_SEARCH)
    lateinit var pagerAdapter: AbstractPagerAdapter

    companion object {
        private val KEY_KEYWORD = "keyWord"
        fun newInstance(keyWord: String): SearchResultFragment {

            return SearchResultFragment().apply {
                val bundle = Bundle()
                bundle.putString(KEY_KEYWORD, keyWord)
                arguments = bundle
            }
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent().inject(this)
    }

    override fun loadData(isRefresh: Boolean) {

    }

    override fun initArgs(savedInstanceState: Bundle?) {
        keyWord=arguments.getString(KEY_KEYWORD)
    }

    override fun initView() {
        mBinding.viewPager.adapter=pagerAdapter
        mBinding.viewPager.offscreenPageLimit=pagerAdapter.count
        (activity as SearchActivity).needShowTab(true)
        (activity as SearchActivity).setupWithViewPager(mBinding.viewPager)
    }

}