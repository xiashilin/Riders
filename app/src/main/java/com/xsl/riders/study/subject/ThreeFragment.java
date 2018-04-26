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
import com.xsl.riders.utils.ioc.OnClick;
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

public class ThreeFragment extends LazyFragment implements SettingItemView.OnSettingItemClick, GridViewAdapter.OnItemClickListener {
    @ViewById(R.id.gv_three)
    private RecyclerView mRecyclerView;
    private GridViewAdapter gridViewAdapter;
    private List<ItemData> itemDatas;

    @ViewById(R.id.three_skill)
    private SettingItemView mItemSkill;
    @ViewById(R.id.three_video)
    private SettingItemView mItemVideo;

    private static ThreeFragment mInstance;

    public static ThreeFragment newInstance() {
        synchronized (ThreeFragment.class) {
            if (mInstance == null) {
                mInstance = new ThreeFragment();
            }
            return mInstance;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_three;
    }

    @Override
    protected void initView(View view) {
        itemDatas = new ArrayList<>();
        itemDatas.add(new ItemData("档位操作", R.mipmap.daoweicaozuo));
        itemDatas.add(new ItemData("变更车道", R.mipmap.biangengchedao));
        itemDatas.add(new ItemData("靠边停车", R.mipmap.kaobiantingche));
        itemDatas.add(new ItemData("超车", R.mipmap.chaoche));
        itemDatas.add(new ItemData("会车", R.mipmap.huiche));
        itemDatas.add(new ItemData("掉头", R.mipmap.diaotou));
        itemDatas.add(new ItemData("直线行驶", R.mipmap.zhixianxingshi));
        itemDatas.add(new ItemData("灯光控制", R.mipmap.dengguangkongzhi));
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
            case R.id.three_skill:
                intentWebView("http://www.baixinxueche.com/webshow/kesan/quanxiang.html", "科目三练习技巧");
                break;
            case R.id.three_video:
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("page", 2);
                getActivity().startActivity(intent);
                break;
        }
    }

    @CheckNet
    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                intentWebView(Constant.BASEURL + "kesan/dangwei.html", itemDatas.get(position).getName());
                break;
            case 1:
                intentWebView(Constant.BASEURL + "kesan/change.html", itemDatas.get(position).getName());
                break;
            case 2:
                intentWebView(Constant.BASEURL + "kesan/stop.html", itemDatas.get(position).getName());
                break;
            case 3:
                intentWebView(Constant.BASEURL + "kesan/car.html", itemDatas.get(position).getName());
                break;
            case 4:
                intentWebView(Constant.BASEURL + "kesan/huiche.html", itemDatas.get(position).getName());
                break;
            case 5:
                intentWebView(Constant.BASEURL + "kesan/diaotou.html", itemDatas.get(position).getName());
                break;
            case 6:
                intentWebView(Constant.BASEURL + "kesan/drive.html", itemDatas.get(position).getName());
                break;
            case 7:
                intentWebView(Constant.BASEURL + "kesan/dengguang.html", itemDatas.get(position).getName());
                break;
        }
    }
}
