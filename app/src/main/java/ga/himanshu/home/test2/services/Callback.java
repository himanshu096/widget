package ga.himanshu.home.test2.services;

/**
 * Created by Himanshu on 7/16/2016.
 */
public interface Callback<T> {

    void onSuccess(T response);


    void onFailure(Error error);
}
