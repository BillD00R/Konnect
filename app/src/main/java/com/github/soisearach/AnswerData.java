package com.github.soisearach;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerData<T> implements Serializable
{

    @SerializedName("serverVersion")
    @Expose
    private String serverVersion;
    @SerializedName("myItems")
    @Expose
    private List<T> myItems = null;
    private final static long serialVersionUID = -5563327941534610429L;

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public List<T> getMyItems() {
        return myItems;
    }

    public void setMyItems(List<T> myItems) {
        this.myItems = myItems;
    }

}