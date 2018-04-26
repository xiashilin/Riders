package com.xsl.riders.pe;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseFragment;
import com.xsl.riders.study.LazyFragment;
import com.xsl.riders.study.adapter.SimpleFragmentPagerAdapter;
import com.xsl.riders.utils.ioc.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/11/27,Time:19:45
 * Description:
 */

public class PrivateEducationFragment extends BaseFragment {
    @ViewById(R.id.pe_tab)
    TabLayout mTabLayout;
    @ViewById(R.id.pe_view_pager)
    ViewPager mViewPager;
    private SimpleFragmentPagerAdapter mAdapter;

    private List<LazyFragment> mFragments = new ArrayList<>();
    private String tabTitles[] = new String[]{"私教", "私教团队", "私教学校"};

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_pe;
    }

    @Override
    protected void initView() {
        mAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager(), mFragments, tabTitles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSmoothScrollingEnabled(true);

        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLayout, 10, 10);
            }
        });
    }

    @Override
    public void initData() {
        mFragments.add(PeFragment.newInstance());
        mFragments.add(PeTeamFragment.newInstance());
        mFragments.add(PeSchoolFragment.newInstance());
    }
}
