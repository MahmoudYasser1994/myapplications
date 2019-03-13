
package com.example.daleel.Models.Check;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private Title title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

}
