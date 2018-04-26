package com.xsl.riders.study;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseFragment;
import com.xsl.riders.study.adapter.SimpleFragmentPagerAdapter;
import com.xsl.riders.study.subject.FourFragment;
import com.xsl.riders.study.subject.OneFragment;
import com.xsl.riders.study.subject.ThreeFragment;
import com.xsl.riders.study.subject.TwoFragment;
import com.xsl.riders.utils.ioc.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/11/27,Time:19:45
 * Description:
 */

public class StudyFragment extends BaseFragment {
    @ViewById(R.id.layout_tab)
    TabLayout mTabLayout;
    @ViewById(R.id.view_pager)
    ViewPager mViewPager;

    private SimpleFragmentPagerAdapter mAdapter;

    private List<LazyFragment> mFragments = new ArrayList<>();
    private String tabTitles[] = new String[]{"科目一", "科目二", "科目三", "科目四"};

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_study;
    }

    @Override
    protected void initView() {
            mAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager(), mFragments, tabTitles);
            mViewPager.setAdapter(mAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
            mTabLayout.setSmoothScrollingEnabled(true);
    }

    @Override
    public void initData() {
        mFragments.add(OneFragment.newInstance());
        mFragments.add(TwoFragment.newInstance());
        mFragments.add(ThreeFragment.newInstance());
        mFragments.add(FourFragment.newInstance());

    }
}
