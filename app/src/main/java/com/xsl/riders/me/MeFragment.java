package com.xsl.riders.me;

import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;
import com.squareup.picasso.Picasso;
import com.xsl.riders.R;
import com.xsl.riders.base.BaseFragment;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.main.LoginActivity;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.ToastUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.widget.SettingItemView;

import java.io.File;

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
    @ViewById(R.id.item_feedback)
    private SettingItemView mItemFeedBack;

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
        mItemFeedBack.setOnSettingItemClick(this);
    }

    @Override
    public void initData() {
        initUserData();

    }

    private void initUserData() {
        if (AVUser.getCurrentUser() != null) {
            mUserName.setText(AVUser.getCurrentUser().getUsername());
            Picasso.with(getContext()).load(AVUser.getCurrentUser().getAVFile("image") == null ? "www" : AVUser.getCurrentUser().getAVFile("image").getUrl()).into(mUserIcon);
        } else {
            mUserName.setText("点击登录");
            Picasso.with(getContext()).load(R.mipmap.ic_def_icon).into(mUserIcon);
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
                    goActivity(getContext(), CollectActivity.class);
                    break;
                case R.id.item_feedback:
                    goActivity(getContext(), FeedBackActivity.class);
                    break;
            }

        } else {
            ToastUtils.show(getContext(), "请登录...");
            this.startActivityForResult(new Intent(getContext(), LoginActivity.class), getActivity().RESULT_FIRST_USER);
        }
    }

    @OnClick(R.id.user_info)
    private void click() {
        if (checkLogin()) {
            goActivity(getContext(), UserInfoActivity.class);
        } else

        {
            ToastUtils.show(getContext(), "请登录...");
            this.startActivityForResult(new Intent(getContext(), LoginActivity.class), getActivity().RESULT_FIRST_USER);
        }

    }

    protected boolean checkLogin() {
        if (AVUser.getCurrentUser() != null) {
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
