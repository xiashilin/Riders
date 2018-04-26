package com.xsl.riders.main;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.home.HomeFragment;
import com.xsl.riders.me.MeFragment;
import com.xsl.riders.pe.PrivateEducationFragment;
import com.xsl.riders.study.StudyFragment;
import com.xsl.riders.utils.FragmentManagerHelper;
import com.xsl.riders.utils.NetUtils;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;
import com.xsl.riders.widget.navigationbar.BottomNavigationBar;

/**
 * @author xsl
 */
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @ViewById(R.id.navigation)
    private BottomNavigationBar mNavigation;
    private FragmentManagerHelper fmHelper;

    private HomeFragment homeFragment;
    private PrivateEducationFragment peFragment;
    private StudyFragment studyFragment;
    private MeFragment meFragment;

    @Override
    protected int getLayout() {
        return R.layout.ay_main;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        checkNet();
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        initData();
    }

    private void checkNet() {
        if (!NetUtils.isConnected(this)) {
            new AlertDialog.Builder(this)
                    .setTitle("网络提示")
                    .setMessage("亲，您的网络不太给力哦 ！")
                    .setCancelable(false)
                    .setPositiveButton("去打开", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            NetUtils.openSetting(MainActivity.this);

                        }
                    }).show();

        }
    }

    private void initData() {
        //初始化FragmentManagerHelper对象
        fmHelper = new FragmentManagerHelper(getSupportFragmentManager(), R.id.fl);
        //设置当前页为首页
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        fmHelper.addFragment(homeFragment);
        mNavigation.setCurrentItem(0);
        //设置为正常的
        mNavigation.setNormalBar();
        mNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fmHelper.switchFragment(homeFragment);
                break;
            case R.id.navigation_pe:
                if (peFragment == null) {
                    peFragment = new PrivateEducationFragment();
                }
                fmHelper.switchFragment(peFragment);
                break;
            case R.id.navigation_study:
                if (studyFragment == null) {
                    studyFragment = new StudyFragment();
                }
                fmHelper.switchFragment(studyFragment);
                break;
            case R.id.navigation_me:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                }
                fmHelper.switchFragment(meFragment);
                break;
            default:
                break;
        }
        return true;
    }

}
