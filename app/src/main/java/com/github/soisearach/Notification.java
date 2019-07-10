package com.github.soisearach;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification implements Serializable
{

    @SerializedName("tickerText")
    @Expose
    private String tickerText;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -3964758439128846578L;

    public String getTickerText() {
        return tickerText;
    }

    public void setTickerText(String tickerText) {
        this.tickerText = tickerText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}