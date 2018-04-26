package com.xsl.riders.main.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.utils.ProgressUtils;
import com.xsl.riders.utils.SharedPUtils;
import com.xsl.riders.utils.StringUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.widget.OwlView;


/**
 * Created by gy on 2017/12/8.
 */
public class LoginActivity extends BaseActivity implements UserLogView, View.OnFocusChangeListener {

    @ViewById(R.id.owl_view)
    OwlView mOwlView;
    @ViewById(R.id.login_et_email)
    EditText emailET;
    @ViewById(R.id.login_et_username)
    EditText usernameET;
    @ViewById(R.id.login_et_password)
    EditText passwordET;
    @ViewById(R.id.login_et_rpassword)
    EditText rpasswordET;
    @ViewById(R.id.login_tv_sign)
    TextView signTV;
    @ViewById(R.id.login_btn_login)
    Button loginBtn;

    //是否是登陆操作
    private boolean isLogin = true;

    private UserLogPresenter userLogPresenter;

    @Override
    protected int getLayout() {


        return R.layout.ay_user_login;
    }

    @Override
    protected void initEventAndData() {
        ViewUtils.inject(this);
        userLogPresenter = new UserLogPresenterImp(this);
        passwordET.setOnFocusChangeListener(this);
        rpasswordET.setOnFocusChangeListener(this);
    }

    /**
     * 监听点击事件
     *
     * @param view
     */
    @OnClick({R.id.login_tv_sign, R.id.login_btn_login, R.id.login_tv_forget})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:  //button
                if (isLogin) {
                    login();  //登陆
                } else {
                    sign();  //注册
                }
                break;
            case R.id.login_tv_sign:  //sign
                if (isLogin) {
                    //置换注册界面
                    signTV.setText("Login");
                    loginBtn.setText("Sign Up");
                    rpasswordET.setVisibility(View.VISIBLE);
                    emailET.setVisibility(View.VISIBLE);
                } else {
                    //置换登陆界面
                    signTV.setText("Sign Up");
                    loginBtn.setText("Login");
                    rpasswordET.setVisibility(View.GONE);
                    emailET.setVisibility(View.GONE);
                }
                isLogin = !isLogin;
                break;

            case R.id.login_tv_forget:  //忘记密码
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;

            default:
                break;
        }
    }

    /**
     * 执行登陆动作
     */
    public void login() {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        if (username.length() == 0 || password.length() == 0) {
            SnackBarUtils.show(mContext, "用户名或密码不能为空");
            return;
        }

        ProgressUtils.show(this, "正在登陆...");

        userLogPresenter.login(username, password);
    }

    /**
     * 执行注册动作
     */
    public void sign() {
        String email = emailET.getText().toString();
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String rpassword = rpasswordET.getText().toString();
        if (email.length() == 0 || username.length() == 0 || password.length() == 0 || rpassword.length() == 0) {
            SnackBarUtils.show(mContext, "请填写必要信息");
            return;
        }
        if (!StringUtils.checkEmail(email)) {
            SnackBarUtils.show(mContext, "请输入正确的邮箱格式");
            return;
        }
        if (!password.equals(rpassword)) {
            SnackBarUtils.show(mContext, "两次密码不一致");
            return;
        }

        ProgressUtils.show(this, "正在注册...");

        userLogPresenter.signup(username, password, email);

    }

    @Override
    public void loadDataSuccess(UserBean tData) {
        ProgressUtils.dismiss();
        if (isLogin) {
            if (tData.getState() == 1) {
                SharedPUtils.put(this, "login", true);
                SharedPUtils.setCurrentUser(mContext, tData);
                setResult(RESULT_OK, new Intent());
                SnackBarUtils.show(mContext, "登陆成功");
                finish();
            } else {
                SnackBarUtils.show(mContext, "请先登陆邮箱激活账号");
            }
        } else {
            SnackBarUtils.show(mContext, "注册成功，请先登陆邮箱验证后登陆");
        }

    }

    @Override
    public void loadDataError(Throwable throwable) {
        ProgressUtils.dismiss();
        SnackBarUtils.show(mContext, throwable.getMessage() + throwable.toString());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            mOwlView.open();
        } else {
            mOwlView.close();
        }
    }
}
