package com.xsl.riders.common;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.utils.statusbar.StatusBarUtils;
import com.xsl.riders.widget.ProgressWebView;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/12/29,Time:21:18
 * Description:
 */

public class WebViewActivity extends BaseActivity {
    @ViewById(R.id.baseweb_webview)
    private ProgressWebView mWebView;
    @ViewById(R.id.toolbar)
    private Toolbar mToolbar;

    @Override
    protected int getLayout() {
        return R.layout.ay_webview;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        initToolBar();
        initData();
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                } else {
                    view.loadUrl(request.toString());
                }
                return true;
            }
        });
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

        String url = intent.getStringExtra("url");
        if (url != null) {
            mWebView.loadUrl(url);
        }
        mToolbar.setTitle(intent.getStringExtra("name"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        mWebView.destroy();
        finish();
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mWebView.destroy();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mWebView.destroy();
                finish();
                break;
        }
        return true;
    }

}
