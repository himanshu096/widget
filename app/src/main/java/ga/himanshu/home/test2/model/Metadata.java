package ga.himanshu.home.test2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Himanshu on 7/16/2016.
 */
public class Metadata {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fields")
    @Expose
    private Fields fields;
    @SerializedName("descriptives")
    @Expose
    private Descriptives descriptives;
    @SerializedName("dates")
    @Expose
    private Dates dates;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The fields
     */
    public Fields getFields() {
        return fields;
    }

    /**
     *
     * @param fields
     * The fields
     */
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    /**
     *
     * @return
     * The descriptives
     */
    public Descriptives getDescriptives() {
        return descriptives;
    }

    /**
     *
     * @param descriptives
     * The descriptives
     */
    public void setDescriptives(Descriptives descriptives) {
        this.descriptives = descriptives;
    }

    /**
     *
     * @return
     * The dates
     */
    public Dates getDates() {
        return dates;
    }

    /**
     *
     * @param dates
     * The dates
     */
    public void setDates(Dates dates) {
        this.dates = dates;
    }

}