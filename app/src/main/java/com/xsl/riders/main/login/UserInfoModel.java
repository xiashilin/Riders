package com.xsl.riders.main.login;

public interface UserInfoModel {

    void update(int id, String username, String gengder, String phone, String mail);

    void onUnsubscribe();
}
