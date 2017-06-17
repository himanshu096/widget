package ga.himanshu.home.test2.services;

import ga.himanshu.home.test2.model.Datum;
import ga.himanshu.home.test2.model.Message;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Himanshu on 7/16/2016.
 */
public interface NoticeServiceInterface {
    @FormUrlEncoded
    @POST("login.xml")
    Call<Message> getNotices(@Field("a") String timestamp,@Field("mode") int some,@Field("password") String password,@Field("producttype") int zero,@Field("username") String username);


}
