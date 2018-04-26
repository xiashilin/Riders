package com.xsl.riders.study.exam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.study.exam.subject1.Subject1FlowTrainingFragment;
import com.xsl.riders.study.exam.subject1.Subject1MockExamFragment;
import com.xsl.riders.study.exam.subject1.Subject1RandomTrainingFragment;
import com.xsl.riders.study.exam.subject4.Subject4FlowTrainingFragment;
import com.xsl.riders.study.exam.subject4.Subject4MockExamFragment;
import com.xsl.riders.study.exam.subject4.Subject4RandomTrainingFragment;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/20,Time:17:20
 * Description:
 */

public class ExamActivity extends BaseActivity {
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;
    private FragmentTransaction ft;

    private String title;

    @Override
    protected int getLayout() {
        return R.layout.ay_exam;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        ft = getSupportFragmentManager().beginTransaction();
        initToolBar();
        initData();
    }

    private void initToolBar() {
        StatusBarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
    }

    private void initData() {
        Intent intent = getIntent();
        int subject = intent.getIntExtra("subject", 1);
        String type = intent.getStringExtra("trainingType");
        title = intent.getStringExtra("title");
        if (subject == 1 && type.equals("flow")) {
            ft.replace(R.id.fl, new Subject1FlowTrainingFragment());
            ft.commit();
        }
        if (subject == 1 && type.equals("random")) {
            ft.replace(R.id.fl, new Subject1RandomTrainingFragment());
            ft.commit();
        }
        if (subject == 1 && type.equals("mock")) {
            ft.replace(R.id.fl, new Subject1MockExamFragment());
            ft.commit();
        }
        if (subject == 4 && type.equals("flow")) {
            ft.replace(R.id.fl, new Subject4FlowTrainingFragment());
            ft.commit();
        }
        if (subject == 4 && type.equals("random")) {
            ft.replace(R.id.fl, new Subject4RandomTrainingFragment());
            ft.commit();
        }
        if (subject == 4 && type.equals("mock")) {
            ft.replace(R.id.fl, new Subject4MockExamFragment());
            ft.commit();
        }
        mToolbar.setTitle(title);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("是否退出" + title + "?")
                        .setCancelable(false)
                        .setPositiveButton("不练了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("再练练", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
                break;
        }
        return true;
    }
}
