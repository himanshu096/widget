package ga.himanshu.home.test2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Himanshu on 7/16/2016.
 */
public class Datum {

    @SerializedName("__metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("notice")
    @Expose
    private String notice;

    /**
     *
     * @return
     * The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     *
     * @param metadata
     * The __metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     *
     * @param branch
     * The branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     *
     * @return
     * The notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     *
     * @param notice
     * The notice
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

}
