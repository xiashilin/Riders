package com.xsl.riders.home;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;
import com.xsl.riders.widget.SettingItemView;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/26,Time:14:24
 * Description:
 */

public class SignUpActivity extends BaseActivity {

    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;
    /****请输入身份证号****/
    @ViewById(R.id.ev_phone)
    private EditText mEvPhone;

    @ViewById(R.id.rb_union_pay)
    private RadioButton mRbUnionPay;

    @ViewById(R.id.rb_alipay)
    private RadioButton mRbAlipay;

    @ViewById(R.id.rb_wxpay)
    private RadioButton mRbWxpay;

    @ViewById(R.id.sign_address)
    private SettingItemView mSignAddress;


    @Override
    protected int getLayout() {
        return R.layout.ay_sign_up;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        initToolBar();
        if (checkLogin()) {
            UserBean userBean = SharedPUtils.getCurrentUser(this);
            mEvPhone.setText(userBean.getPhone());
        }
        mSignAddress.setOnSettingItemClick(new SettingItemView.OnSettingItemClick() {
            @Override
            public void click(View view, boolean isChecked) {
                SnackBarUtils.show(mContext, "暂未开发");
            }
        });
    }

    private void initToolBar() {
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        mToolbar.setTitle("私教报名");
    }

    @OnClick({R.id.rl_alipay, R.id.rl_weixinpay, R.id.rl_union, R.id.rb_wxpay, R.id.rb_alipay, R.id.rb_union_pay, R.id.tv_submit})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.rl_union:
                mRbUnionPay.setChecked(true);
                mRbAlipay.setChecked(false);
                mRbWxpay.setChecked(false);
                break;
            case R.id.rl_alipay:
                mRbUnionPay.setChecked(false);
                mRbAlipay.setChecked(true);
                mRbWxpay.setChecked(false);
                break;
            case R.id.rl_weixinpay:
                mRbUnionPay.setChecked(false);
                mRbAlipay.setChecked(false);
                mRbWxpay.setChecked(true);
                break;
            case R.id.rb_union_pay:
                mRbUnionPay.setChecked(true);
                mRbAlipay.setChecked(false);
                mRbWxpay.setChecked(false);
                break;
            case R.id.rb_alipay:
                mRbUnionPay.setChecked(false);
                mRbAlipay.setChecked(true);
                mRbWxpay.setChecked(false);
                break;
            case R.id.rb_wxpay:
                mRbUnionPay.setChecked(false);
                mRbAlipay.setChecked(false);
                mRbWxpay.setChecked(true);
                break;
            case R.id.tv_submit:
                SnackBarUtils.show(mContext, "暂未开发");
                break;
        }
    }

}
