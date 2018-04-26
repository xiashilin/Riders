package com.xsl.riders.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;
import com.xsl.riders.widget.SettingItemView;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/12/30,Time:13:18
 * Description:
 */

public class SignActivity extends BaseActivity implements SettingItemView.OnSettingItemClick {
    @ViewById(R.id.item_one)
    private SettingItemView mItemOne;
    @ViewById(R.id.item_two)
    private SettingItemView mItemTwo;
    @ViewById(R.id.item_three)
    private SettingItemView mItemThree;
    @ViewById(R.id.item_four)
    private SettingItemView mItemFour;
    @ViewById(R.id.item_five)
    private SettingItemView mItemFive;
    @ViewById(R.id.item_six)
    private SettingItemView mItemSix;
    @ViewById(R.id.item_seven)
    private SettingItemView mItemSeven;
    @ViewById(R.id.item_eight)
    private SettingItemView mItemEight;
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;

    @Override
    protected int getLayout() {
        return R.layout.ay_sign;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        initToolBar();
        mItemOne.setOnSettingItemClick(this);
        mItemTwo.setOnSettingItemClick(this);
        mItemThree.setOnSettingItemClick(this);
        mItemFour.setOnSettingItemClick(this);
        mItemFive.setOnSettingItemClick(this);
        mItemSix.setOnSettingItemClick(this);
        mItemSeven.setOnSettingItemClick(this);
        mItemEight.setOnSettingItemClick(this);
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        mToolbar.setTitle(getString(R.string.jtbz));
    }

    @Override
    public void click(View view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.item_one:
                intentWebWiew(Constant.BASEURL + "keyi/zsbz.html", getString(R.string.zsbz));
                break;
            case R.id.item_two:
                intentWebWiew(Constant.BASEURL + "keyi/jlbz.html", getString(R.string.jlbz));
                break;
            case R.id.item_three:
                intentWebWiew(Constant.BASEURL + "keyi/jgbz.html", getString(R.string.jgbz));
                break;
            case R.id.item_four:
                intentWebWiew(Constant.BASEURL + "keyi/fzbz.html", getString(R.string.fzbz));
                break;
            case R.id.item_five:
                intentWebWiew(Constant.BASEURL + "keyi/dlbz.html", getString(R.string.zlbz));
                break;
            case R.id.item_six:
                intentWebWiew(Constant.BASEURL + "keyi/dlbx.html", getString(R.string.dljtbx));
                break;
            case R.id.item_seven:
                intentWebWiew(Constant.BASEURL + "keyi/dlsg.html", getString(R.string.dlsgbx));
                break;
            case R.id.item_eight:
                intentWebWiew(Constant.BASEURL + "lybz.html", getString(R.string.lybz));
                break;
        }
    }


    public void intentWebWiew(String url, String name) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
