package com.xsl.riders.main.login;


public abstract  class UserLogPresenter extends BasePresenter {

    public abstract void login(String username, String password);

    public abstract void signup(String username, String password, String mail);
}
