package com.xsl.riders.home;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/26,Time:14:32
 * Description:
 */

public class InviteActivity extends BaseActivity {
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;
    /****18795890021****/
    @ViewById(R.id.share_code)
    private TextView mShareCode;

    @Override
    protected int getLayout() {
        return R.layout.ay_invite;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        initToolBar();
        if (checkLogin()) {
            UserBean userBean = SharedPUtils.getCurrentUser(this);
            mShareCode.setText(userBean.getPhone());
        }

    }

    private void initToolBar() {
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        mToolbar.setTitle("发送邀请");
    }

    @OnClick({R.id.share_qq, R.id.share_friendcricle, R.id.share_weixin, R.id.share_sina})
    private void click(View view) {

        SnackBarUtils.show(this, "暂未开发");

    }
}
