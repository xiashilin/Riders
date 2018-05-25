package com.xsl.riders.me;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.EditText;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ToastUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;


/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/4/22,Time:17:57
 * Description:
 */

public class FeedBackActivity extends BaseActivity {
    @ViewById(R.id.toolbar)
    Toolbar mToolbar;
    @ViewById(R.id.feedback_content)
    EditText mContent;

    @Override
    protected int getLayout() {
        return R.layout.ay_feedback;
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
        mToolbar.setTitle("反馈");
    }

    @OnClick(R.id.feedback_btn_submit)
    public void Click() {
        if (TextUtils.isEmpty(mContent.getText().toString().trim())) {
            SnackBarUtils.show(mContext, "请输入内容");
            return;
        }
        ToastUtils.show(mContext, "反馈成功！我们会尽快处理");
        finish();
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
