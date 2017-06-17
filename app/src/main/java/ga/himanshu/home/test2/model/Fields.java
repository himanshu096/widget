package ga.himanshu.home.test2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Himanshu on 7/16/2016.
 */
public class Fields {
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("branch")
    @Expose
    private Branch branch;
    @SerializedName("notice")
    @Expose
    private Notice notice;

    /**
     *
     * @return
     * The id
     */
    public Id getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The branch
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     *
     * @param branch
     * The branch
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    /**
     *
     * @return
     * The notice
     */
    public Notice getNotice() {
        return notice;
    }

    /**
     *
     * @param notice
     * The notice
     */
    public void setNotice(Notice notice) {
        this.notice = notice;
    }

}
