package com.xsl.riders.main.login;


import com.xsl.riders.base.BaseObserver;
import com.xsl.riders.common.UserBean;
import com.xsl.riders.net.HttpManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserInfoModelImp implements UserInfoModel {

    private UserInfoOnListener listener;

    public UserInfoModelImp(UserInfoOnListener listener) {
        this.listener = listener;
    }

    @Override
    public void update(int id, String username, String gengder, String phone, String mail) {

        HttpManager.getInstance().getApiService("http://139.199.176.173:8080/ssmBillBook/")
                .updateUser(id, username, gengder, phone, mail).subscribe(new BaseObserver<UserBean>() {
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
    public interface UserInfoOnListener {

        void onSuccess(UserBean user);

        void onFailure(Throwable e);
    }
}
