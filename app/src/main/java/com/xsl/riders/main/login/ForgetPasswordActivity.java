package com.xsl.riders.main.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.xsl.riders.R;
import com.xsl.riders.base.BaseActivity;
import com.xsl.riders.utils.OkHttpUtils;
import com.xsl.riders.utils.RegexUtils;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.OnClick;
import com.xsl.riders.utils.ioc.ViewById;
import com.xsl.riders.utils.ioc.ViewUtils;
import com.xsl.riders.widget.VerifyCodeButton;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 忘记密码 Activity
 */
public class ForgetPasswordActivity extends BaseActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.til_username)
    TextInputLayout mTilName;
    @ViewById(R.id.til_mail)
    TextInputLayout mTilMail;
    @ViewById(R.id.til_code)
    TextInputLayout mTilCode;
    @ViewById(R.id.btn_get_code)
    VerifyCodeButton mBtnGetCode;
    @ViewById(R.id.til_password)
    TextInputLayout mTilPassword;

    private EditText mEdtName;
    private EditText mEdtMail;
    private EditText mEdtCode;
    private EditText mEdtPassword;

    @Override
    protected int getLayout() {
        return R.layout.ay_forget_password;
    }

    @Override
    protected void initEventAndData() {
        //初始化Toolbar
        toolbar.setTitle("找回密码");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回消息更新上个Activity数据
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });

        mEdtName = mTilName.getEditText();
        mEdtMail = mTilMail.getEditText();
        mEdtCode = mTilCode.getEditText();
        mEdtPassword = mTilPassword.getEditText();

        mEdtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTilName.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mEdtMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String mail = charSequence.toString();
                if (!RegexUtils.isEmail(mail)) {
                    mEdtMail.setError("请输入正确的邮箱地址");
                } else {
                    mTilCode.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mEdtCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String code = charSequence.toString();
                if (!RegexUtils.checkCode(code)) {
                    mTilCode.setError("请输入正确的验证码");
                } else {
                    mTilCode.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mEdtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();
                if (!RegexUtils.checkPassword(password)) {
                    mTilPassword.setError("请输入正确的密码");
                } else {
                    mTilPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    @OnClick({R.id.btn_get_code, R.id.btn_finish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_code: // 获取验证码
                getCode();
                break;
            case R.id.btn_finish:   // 完成
                forgetPasswordFinish();
                break;
        }
    }

    private void getCode() {
        String username = mEdtName.getText().toString();
        String mail = mEdtMail.getText().toString();

        if (username.length() == 0) {
            Toast.makeText(mContext, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mail.length() == 0) {
            Toast.makeText(mContext, "请输入注册邮箱", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("mail", mail);
        OkHttpUtils.getInstance().get("http://139.199.176.173:8080/ssmBillBook" + "/user/forgetPw", params,
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(mContext, "修改失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) {
                        mContext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mBtnGetCode.start();
                                Toast.makeText(mContext, "已向您的注册邮箱发送验证码", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

    }

    private void forgetPasswordFinish() {
        String username = mEdtName.getText().toString();
        String code = mEdtCode.getText().toString();
        String newPassword = mEdtPassword.getText().toString();
        if (!RegexUtils.checkCode(code)) {
            SnackBarUtils.show(mContext, "请输入正确的验证码");
        } else if (!RegexUtils.checkPassword(newPassword)) {
            SnackBarUtils.show(mContext, "请输入正确的密码");
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("username", username);
            params.put("password", newPassword);
            params.put("code", code);
            OkHttpUtils.getInstance().get("http://139.199.176.173:8080/ssmBillBook" + "/user/changePw", params,
                    new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Toast.makeText(mContext, "修改失败", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) {
                            Toast.makeText(mContext, "修改成功，请返回登陆", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
