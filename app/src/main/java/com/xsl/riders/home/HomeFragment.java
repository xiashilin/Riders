package com.xsl.riders.home;


import android.content.Intent;
import android.view.View;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseFragment;
import com.xsl.riders.main.login.LoginActivity;
import com.xsl.riders.utils.PicassoImageLoader;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ToastUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/11/27,Time:19:40
 * Description:
 */

public class HomeFragment extends BaseFragment {

    @ViewById(R.id.banner)
    Banner banner;

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {
        List<String> images = new ArrayList<>();
        images.add("http://lc-3xagb7rq.cn-n1.lcfile.com/eb5607bbe45a02475f0b.png");
        images.add("http://lc-3xagb7rq.cn-n1.lcfile.com/f71520fd6acb3e421cda.png");
        images.add("http://lc-3xagb7rq.cn-n1.lcfile.com/f631953f3958c51007d8.png");
        banner.setImages(images).setImageLoader(new PicassoImageLoader()).start();
    }

    @OnClick({R.id.ll_place, R.id.ll_private_signUp, R.id.ll_peiLian, R.id.ll_invite})
    private void click(View view) {
        switch (view.getId()) {
            case R.id.ll_place:
                goActivity(getContext(), SchoolActivity.class);
                break;
            case R.id.ll_private_signUp:
                if (checkLogin()) {
                    goActivity(getContext(), SignUpActivity.class);
                }
                break;
            case R.id.ll_peiLian:
                goActivity(getContext(), PeActivity.class);
                break;
            case R.id.ll_invite:
                if (checkLogin()) {
                    goActivity(getContext(), InviteActivity.class);
                }
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    private boolean checkLogin() {
        boolean isLogin = (boolean) SharedPUtils.get(getContext(), "login", false);
        if (isLogin) {
            return true;
        } else {
            ToastUtils.show(getContext(), "请登录...");
            this.startActivityForResult(new Intent(getContext(), LoginActivity.class), getActivity().RESULT_FIRST_USER);
        }

        return false;
    }
}
