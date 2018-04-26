package com.xsl.riders.study.subject;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xsl.riders.R;
import com.xsl.riders.common.Constant;
import com.xsl.riders.study.ItemData;
import com.xsl.riders.study.LazyFragment;
import com.xsl.riders.study.VideoActivity;
import com.xsl.riders.study.adapter.GridViewAdapter;
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

public class TwoFragment extends LazyFragment implements SettingItemView.OnSettingItemClick, GridViewAdapter.OnItemClickListener {
    @ViewById(R.id.gv_two)
    private RecyclerView mRecyclerView;
    private List<ItemData> itemDatas;
    private static TwoFragment mInstance;

    @ViewById(R.id.two_skill)
    private SettingItemView mItemSkill;
    @ViewById(R.id.two_video)
    private SettingItemView mItemVideo;

    private GridViewAdapter gridViewAdapter;

    public static TwoFragment newInstance() {
        synchronized (TwoFragment.class) {
            if (mInstance == null) {
                mInstance = new TwoFragment();
            }
            return mInstance;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_two;
    }

    @Override
    protected void initView(View view) {
        itemDatas = new ArrayList<>();
        itemDatas.add(new ItemData("座椅", R.mipmap.icon_chair));
        itemDatas.add(new ItemData("安全带", R.mipmap.safety_belt));
        itemDatas.add(new ItemData("方向盘", R.mipmap.steering_wheel));
        itemDatas.add(new ItemData("离合", R.mipmap.clutch));
        itemDatas.add(new ItemData("倒车镜", R.mipmap.icon_dcj));
        itemDatas.add(new ItemData("制动踏板", R.mipmap.icon_zdtb));
        itemDatas.add(new ItemData("驻车制动", R.mipmap.icon_zczd));
        gridViewAdapter = new GridViewAdapter(itemDatas, getContext());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(gridViewAdapter);

        mItemSkill.setOnSettingItemClick(this);
        mItemVideo.setOnSettingItemClick(this);
    }

    @Override
    public void initData() {

        gridViewAdapter.setOnItemClickListener(this);


    }

    @CheckNet
    @Override
    public void click(View view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.two_skill:
                intentWebView("http://www.baixinxueche.com/webshow/keer/keer.html", "科目二练习技巧");
                break;
            case R.id.two_video:
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("page", 1);
                getActivity().startActivity(intent);
                break;
        }
    }

    @CheckNet
    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                intentWebView(Constant.BASEURL + "keer/zuoyi.html", itemDatas.get(position).getName());
                break;
            case 1:
                intentWebView(Constant.BASEURL + "keer/safe.html", itemDatas.get(position).getName());
                break;
            case 2:
                intentWebView(Constant.BASEURL + "keer/wheel.html", itemDatas.get(position).getName());
                break;
            case 3:
                intentWebView(Constant.BASEURL + "keer/clutch.html", itemDatas.get(position).getName());
                break;
            case 4:
                intentWebView(Constant.BASEURL + "keer/rearview-mirror.html", itemDatas.get(position).getName());
                break;
            case 5:
                intentWebView(Constant.BASEURL + "keer/brake.html", itemDatas.get(position).getName());
                break;
            case 6:
                intentWebView(Constant.BASEURL + "keer/stop.html", itemDatas.get(position).getName());
                break;
        }
    }
}
