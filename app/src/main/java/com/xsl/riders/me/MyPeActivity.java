package com.xsl.riders.me;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/25,Time:16:26
 * Description:
 */

public class MyPeActivity extends BaseActivity {
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;


    @Override
    protected int getLayout() {
        return R.layout.ay_pe;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        initToolBar();

    }

    private void initToolBar() {
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        mToolbar.setTitle("我的教练");
    }
    @OnClick(R.id.add_btn)
    private void onclick(){
        SnackBarUtils.show(this, "暂未开发");
    }
}
