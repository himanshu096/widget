package ga.himanshu.home.test2.services;

import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;

import ga.himanshu.home.test2.model.Message;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Himanshu on 7/16/2016.
 */
public class MyNoticeService {

    private final String BASE_URL = "http://10.1.1.1:8090/";
    private final String accessToken="8b0f1191-0167-4f58-ad07-dcaf9c35904a";
    private NoticeServiceInterface service;
    private Retrofit retrofit;

   public MyNoticeService(){


       retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       service = retrofit.create(NoticeServiceInterface.class);
   }

    public void listNotices(String timestamp,Callback<Message> callback){
        service.getNotices(timestamp,191,"gaurav",0,"2014bcs1131").enqueue(new CallbackHandler<Message>(retrofit,callback));;
    }





















private class CallbackHandler<T> implements retrofit2.Callback<T> {

    private Retrofit retrofit;
    private Callback callback;

    public CallbackHandler(Retrofit retrofit, Callback callback) {
        this.retrofit = retrofit;
        this.callback = callback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            Log.d("codekamp", "response isSuccessful");

            Converter<ResponseBody, Error> errorConverter =
                    retrofit.responseBodyConverter(Error.class, new Annotation[0]);
            try {
                Error error = errorConverter.convert(response.errorBody());
                callback.onFailure(error);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d("codekamp", "response onFailure");

        Error error = new Error("error occured");

        callback.onFailure(error);
    }
}
}
