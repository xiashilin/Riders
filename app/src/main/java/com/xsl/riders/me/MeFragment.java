package com.xsl.riders.me;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xsl.riders.R;
import com.xsl.riders.base.BaseFragment;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.main.login.LoginActivity;
import com.xsl.riders.utils.PicassoImageLoader;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ToastUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.widget.SettingItemView;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/11/27,Time:19:44
 * Description:
 */

public class MeFragment extends BaseFragment implements SettingItemView.OnSettingItemClick {
    @ViewById(R.id.user_icon)
    private ImageView mUserIcon;
    /****惟愿无事常相见****/
    @ViewById(R.id.user_name)
    private TextView mUserName;
    /****手机号:18795890071****/
    @ViewById(R.id.user_phone)
    private TextView mUserPhone;
    @ViewById(R.id.item_info)
    private SettingItemView mItemInfo;
    @ViewById(R.id.item_pe)
    private SettingItemView mItemPe;
    @ViewById(R.id.item_process)
    private SettingItemView mItemProcess;
    @ViewById(R.id.item_money)
    private SettingItemView mItemMoney;
    @ViewById(R.id.item_circle)
    private SettingItemView mItemCircle;
    @ViewById(R.id.item_collection)
    private SettingItemView mItemCollection;

    @Override
    protected int getLayoutRes() {

        return R.layout.fg_me;
    }

    @Override
    protected void initView() {
        mItemInfo.setOnSettingItemClick(this);
        mItemPe.setOnSettingItemClick(this);
        mItemProcess.setOnSettingItemClick(this);
        mItemMoney.setOnSettingItemClick(this);
        mItemCircle.setOnSettingItemClick(this);
        mItemCollection.setOnSettingItemClick(this);
    }

    @Override
    public void initData() {
        initUserData();

    }

    private void initUserData() {
        UserBean userBean = SharedPUtils.getCurrentUser(getContext());
        if (checkLogin()) {
            //加载当前头像
            String imgPath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/" + userBean.getImage();
            File file = new File(imgPath);
            if (file.exists()) {
                //加载图片
                Picasso.with(getContext()).load(file).into(mUserIcon);

            }
            mUserName.setText(userBean.getUsername());
            mUserPhone.setText(userBean.getPhone());
        }
    }

    @Override
    public void click(View view, boolean isChecked) {

        if (checkLogin()) {

            switch (view.getId()) {
                case R.id.item_info:
                    goActivity(getContext(), MessageActivity.class);
                    break;
                case R.id.item_pe:
                    goActivity(getContext(), MyPeActivity.class);
                    break;
                case R.id.item_process:
                    goActivity(getContext(), ProcessActivity.class);
                    break;
                case R.id.item_money:
                    goActivity(getContext(), WalletActivity.class);
                    break;
                case R.id.item_circle:
                    goActivity(getContext(), FriendCircleActivity.class);
                    break;
                case R.id.item_collection:
                    SnackBarUtils.show(getContext(), "暂未开发");
                    break;
            }

        } else {
            ToastUtils.show(getContext(), "请登录...");
            this.startActivityForResult(new Intent(getContext(), LoginActivity.class), getActivity().RESULT_FIRST_USER);
        }
    }

    @OnClick(R.id.user_info)
    private void click() {
        if (checkLogin())
            goActivity(getContext(), UserInfoActivity.class);
    }

    private boolean checkLogin() {
        boolean isLogin = (boolean) SharedPUtils.get(getContext(), "login", false);
        if (isLogin) {
            return true;
        }

        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initUserData();
    }
}
