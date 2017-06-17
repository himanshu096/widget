package ga.himanshu.home.test2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Himanshu on 7/16/2016.
 */
public class Notice {

    @SerializedName("type")
    @Expose
    private String type;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

}