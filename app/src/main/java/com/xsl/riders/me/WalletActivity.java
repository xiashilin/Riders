package com.xsl.riders.me;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;
import com.xsl.riders.widget.SettingItemView;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/25,Time:16:56
 * Description:
 */

public class WalletActivity extends BaseActivity implements SettingItemView.OnSettingItemClick {
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;

    @ViewById(R.id.item_hours)
    private SettingItemView mItemHours;
    @ViewById(R.id.item_payment)
    private SettingItemView mItemPayment;
    @ViewById(R.id.item_coupon)
    private SettingItemView mItemCoupon;

    @Override
    protected int getLayout() {
        return R.layout.ay_wallet;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        initToolBar();
        mItemHours.setOnSettingItemClick(this);
        mItemPayment.setOnSettingItemClick(this);
        mItemCoupon.setOnSettingItemClick(this);
    }

    private void initToolBar() {
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        mToolbar.setTitle("我的钱包");
    }

    @OnClick(R.id.recharge)
    public void onclick() {
        SnackBarUtils.show(this, "暂未开发");
    }

    @Override
    public void click(View view, boolean isChecked) {
        SnackBarUtils.show(this, "暂未开发");
    }
}
