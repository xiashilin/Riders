package com.xsl.riders.study.subject;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xsl.riders.R;
import com.xsl.riders.common.Constant;
import com.xsl.riders.study.ItemData;
import com.xsl.riders.study.LazyFragment;
import com.xsl.riders.study.adapter.GridViewAdapter;
import com.xsl.riders.study.adapter.GridViewItemDecoration;
import com.xsl.riders.utils.ioc.CheckNet;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.widget.SettingItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/11/28,Time:17:12
 * Description:
 */

public class FourFragment extends LazyFragment implements SettingItemView.OnSettingItemClick {
    @ViewById(R.id.gv_four)
    private RecyclerView mRecyclerView;
    @ViewById(R.id.item_key)
    private SettingItemView mItemKey;
    @ViewById(R.id.item_dashboard)
    private SettingItemView mItemDashboard;
    @ViewById(R.id.item_points)
    private SettingItemView mItemPoints;

    private List<ItemData> itemDatas;

    private String title;
    private int subject;
    private String trainingType;

    private static FourFragment mInstance;

    public static FourFragment newInstance() {
        synchronized (FourFragment.class) {
            if (mInstance == null) {
                mInstance = new FourFragment();
            }
            return mInstance;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_four;
    }

    @Override
    protected void initView(View view) {
        itemDatas = new ArrayList<>();
        itemDatas.add(new ItemData("顺序做题", R.mipmap.practice));
        itemDatas.add(new ItemData("随机做题", R.mipmap.random));
        itemDatas.add(new ItemData("模拟考试", R.mipmap.simulation));
        itemDatas.add(new ItemData("我的错题", R.mipmap.error));

        GridViewAdapter gridViewAdapter = new GridViewAdapter(itemDatas, getContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new GridViewItemDecoration(getContext(), R.drawable.divider));
        mRecyclerView.setAdapter(gridViewAdapter);
        gridViewAdapter.setOnItemClickListener(new GridViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        title = "科目四顺序练题";
                        subject = 4;
                        trainingType = "flow";
                        intentActivity(title, subject, trainingType);
                        break;
                    case 1:
                        title = "科目四随机练题";
                        subject = 4;
                        trainingType = "random";
                        intentActivity(title, subject, trainingType);
                        break;
                    case 2:
                        title = "科目四模拟考试";
                        subject = 4;
                        trainingType = "mock";
                        intentActivity(title, subject, trainingType);
                        break;
                }
            }
        });
        //设置监听

        mItemKey.setOnSettingItemClick(this);
        mItemDashboard.setOnSettingItemClick(this);
        mItemPoints.setOnSettingItemClick(this);
    }

    @Override
    public void initData() {

    }

    @CheckNet
    @Override
    public void click(View view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.item_key:
                intentWebView(Constant.BASEURL + "kesi/gnj.html", getString(R.string.gnaj));
                break;
            case R.id.item_dashboard:
                intentWebView(Constant.BASEURL + "kesi/ybp.html", getString(R.string.qcybp));
                break;
            case R.id.item_points:
                intentWebView("http://www.baixinxueche.com/webshow/jiaogui/desc.html", getString(R.string.jtkf));
                break;
        }
    }
}
