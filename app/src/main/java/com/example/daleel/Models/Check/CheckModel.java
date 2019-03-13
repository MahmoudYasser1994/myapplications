
package com.example.daleel.Models.Check;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckModel {

    @SerializedName("status")
    @Expose
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
