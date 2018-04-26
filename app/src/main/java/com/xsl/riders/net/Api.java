package com.xsl.riders.net;

import com.xsl.riders.common.PeBean;
import com.xsl.riders.common.PeSchoolBean;
import com.xsl.riders.common.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xsl on 2017/11/21.
 */

public interface Api {


    @GET("getPe/page/{page}")
    Observable<PeBean> getPeBean(@Path("page") int page);

    @GET("getPeTeam/page/{page}")
    Observable<PeBean> getPeTeamBean(@Path("page") int page);

    @GET("getPSchool/page/{page}")
    Observable<PeSchoolBean> getPeSchoolBean(@Path("page") int page);

    @GET("user/update")
    Observable<UserBean> updateUser(@Query("id") int id, @Query("username") String username
            , @Query("gender") String gender, @Query("phone") String phone, @Query("mail") String mail);

    @GET("user/login")
    Observable<UserBean> login(@Query("username") String username, @Query("password") String password);

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @param mail
     * @return
     */
    @GET("user/sign")
    Observable<UserBean> signup(@Query("username") String username, @Query("password") String password
            , @Query("mail") String mail);

}
