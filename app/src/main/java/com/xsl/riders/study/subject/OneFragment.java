package com.xsl.riders.study.subject;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xsl.riders.R;
import com.xsl.riders.common.Constant;
import com.xsl.riders.common.SignActivity;
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
 * @author:xsl Date:2017/11/28,Time:17:11
 * Description:
 */

public class OneFragment extends LazyFragment implements SettingItemView.OnSettingItemClick {

    @ViewById(R.id.gridView)
    private RecyclerView mRecyclerView;
    @ViewById(R.id.item_vision)
    private SettingItemView mItemVision;
    @ViewById(R.id.item_sign)
    private SettingItemView mItemSign;
    @ViewById(R.id.item_gesture)
    private SettingItemView mItemGesture;

    private static OneFragment mInstance;
    private List<ItemData> itemDatas;

    private String title;
    private int subject;
    private String trainingType;


    public static OneFragment newInstance() {
        synchronized (OneFragment.class) {
            if (mInstance == null) {
                mInstance = new OneFragment();
            }
            return mInstance;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_one;
    }

    @Override
    protected void initView(View view) {

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
                        title = "科目一顺序练题";
                        subject = 1;
                        trainingType = "flow";
                        intentActivity(title, subject, trainingType);
                        break;
                    case 1:
                        title = "科目一随机练题";
                        subject = 1;
                        trainingType = "random";
                        intentActivity(title, subject, trainingType);
                        break;
                    case 2:
                        title = "科目一模拟考试";
                        subject = 1;
                        trainingType = "mock";
                        intentActivity(title, subject, trainingType);
                        break;
                }

            }
        });

        //设置监听

        mItemVision.setOnSettingItemClick(this);
        mItemSign.setOnSettingItemClick(this);
        mItemGesture.setOnSettingItemClick(this);
    }

    @Override
    public void initData() {
        itemDatas = new ArrayList<>();
        itemDatas.add(new ItemData("顺序做题", R.mipmap.practice));
        itemDatas.add(new ItemData("随机做题", R.mipmap.random));
        itemDatas.add(new ItemData("模拟考试", R.mipmap.simulation));
        itemDatas.add(new ItemData("我的错题", R.mipmap.error));
    }

    @CheckNet
    @Override
    public void click(View view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.item_vision:
                intentWebView(Constant.BASEURL + "keyi/sjcs.html", getString(R.string.sjcs));
                break;
            case R.id.item_sign:
                startActivity(new Intent(getContext(), SignActivity.class));
                break;
            case R.id.item_gesture:
                intentWebView(Constant.BASEURL + "keyi/jjss.html", getString(R.string.jjss));
                break;
        }
    }


}
