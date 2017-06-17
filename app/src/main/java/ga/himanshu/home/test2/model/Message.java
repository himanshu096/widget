package ga.himanshu.home.test2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himanshu on 7/16/2016.
 */
public class Message {
    @SerializedName("totalRows")
    @Expose
    private Integer totalRows;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     *
     * @return
     * The totalRows
     */
    public Integer getTotalRows() {
        return totalRows;
    }

    /**
     *
     * @param totalRows
     * The totalRows
     */
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

}
