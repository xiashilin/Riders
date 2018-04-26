package com.xsl.riders.pe;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.pe.adapter.PeCommentAdapter;
import com.xsl.riders.utils.PicassoImageLoader;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;
import com.xsl.riders.widget.CircleImageView;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/22,Time:9:06
 * Description:
 */

public class PeDetailActivity extends BaseActivity {
    @ViewById(R.id.detail_icon)
    private CircleImageView mDetailIcon;
    /****夏士林****/
    @ViewById(R.id.detail_name)
    private TextView mDetailName;
    /****学时最低价****/
    @ViewById(R.id.detail_price)
    private TextView mDetailPrice;
    /****所在校区:经开区 | 累计人次：30****/
    @ViewById(R.id.detail_school)
    private TextView mDetailSchool;
    /****所在校区:经开区 | 累计人次：30****/
    @ViewById(R.id.detail_address)
    private TextView mDetailAddress;
    /****综合评价:****/
    @ViewById(R.id.detail_zh_star)
    private RatingBar mDetailZhStar;
    /****5.0分****/
    @ViewById(R.id.detail_zh_score)
    private TextView mDetailZhScore;
    /****教学质量:****/
    @ViewById(R.id.detail_jx_star)
    private RatingBar mDetailJxStar;
    /****5.0分****/
    @ViewById(R.id.detail_jx_score)
    private TextView mDetailJxScore;
    /****服务质量:****/
    @ViewById(R.id.detail_fw_star)
    private RatingBar mDetailFwStar;
    /****5.0分****/
    @ViewById(R.id.detail_fw_score)
    private TextView mDetailFwScore;
    @ViewById(R.id.detail_desc)
    private TextView mDetailDesc;
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;
    @ViewById(R.id.rl_comment)
    private RecyclerView mRecyclerView;

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    private String phoneNum;

    @Override
    protected int getLayout() {
        return R.layout.ay_detail;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        initToolBar();
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        PeCommentAdapter peCommentAdapter = new PeCommentAdapter(this);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setAdapter(peCommentAdapter);
    }

    private void initData() {
        Intent intent = getIntent();
        new PicassoImageLoader().displayImage(this, intent.getStringExtra("icon"), mDetailIcon);
        if (intent.getStringExtra("title").equals("私教团队详情")) {
            mDetailName.setText(intent.getStringExtra("name") + "团队");
        } else {
            mDetailName.setText(intent.getStringExtra("name"));
        }

        mDetailPrice.setText("￥" + intent.getStringExtra("price"));
        mDetailSchool.setText("所在校区:" + intent.getStringExtra("school") + "  |  " + "累计人次:" + intent.getIntExtra("student", 0));
        mDetailAddress.setText(intent.getStringExtra("address"));
        mDetailZhStar.setRating(intent.getFloatExtra("zh_rating", 0));
        mDetailZhScore.setText(intent.getFloatExtra("zh_rating", 0) + "");
        mDetailJxStar.setRating(intent.getFloatExtra("jx_rating", 0));
        mDetailJxScore.setText(intent.getFloatExtra("jx_rating", 0) + "");
        mDetailFwStar.setRating(intent.getFloatExtra("fw_rating", 0));
        mDetailFwScore.setText(intent.getFloatExtra("fw_rating", 0) + "");
        mDetailDesc.setText(intent.getStringExtra("desc"));
        mToolbar.setTitle(intent.getStringExtra("title"));
        phoneNum = intent.getStringExtra("phone");
    }

    private void initToolBar() {
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);

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

    @OnClick({R.id.detail_call, R.id.detail_chat})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_call:
                callPhone(phoneNum);
                break;
            case R.id.detail_chat:
                SnackBarUtils.show(PeDetailActivity.this, "暂未开发");
                break;
        }

    }

    /**
     * 拨打电话（直接拨打电话）
     *
     * @param phoneNum 电话号码
     */
    public void callPhone(String phoneNum) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(PeDetailActivity.this,
                    Manifest.permission.CALL_PHONE)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                Toast.makeText(PeDetailActivity.this, "请授权！", Toast.LENGTH_LONG).show();

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(PeDetailActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        } else {
            // 已经获得授权，可以打电话
            Intent i = new Intent(Intent.ACTION_CALL);
            Uri data = Uri.parse("tel:" + phoneNum);
            i.setData(data);
            startActivity(i);
            return;
        }
    }
}
