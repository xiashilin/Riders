package com.xsl.riders.main.login;

import com.xsl.riders.base.BaseObserver;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.net.HttpManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserLogModelImp implements UserLogModel {

    private UserLogOnListener listener;

    public UserLogModelImp(UserLogOnListener listener) {
        this.listener = listener;
    }

    @Override
    public void login(String username, String password) {

        HttpManager.getInstance().getApiService("http://139.199.176.173:8080/ssmBillBook/")
                .login(username, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserver<UserBean>() {
            @Override
            protected void onSuccees(UserBean userBean) throws Exception {
                listener.onSuccess(userBean);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                listener.onFailure(e);
            }
        });
    }

    @Override
    public void signup(String username, String password, String mail) {

        HttpManager.getInstance().getApiService("http://139.199.176.173:8080/ssmBillBook/")
                .signup(username, password, mail).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserver<UserBean>() {
            @Override
            protected void onSuccees(UserBean userBean) throws Exception {
                listener.onSuccess(userBean);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                listener.onFailure(e);
            }
        });
    }

    @Override
    public void onUnsubscribe() {

    }

    /**
     * 回调接口
     */
    public interface UserLogOnListener {

        void onSuccess(UserBean user);

        void onFailure(Throwable e);
    }
}
