package com.menulaterala.central.loadimagesasync;

/**
 * Created by central on 27/10/2016.
 */
public class ModelCategory {
    private String title;
    private String url;

    public ModelCategory(String title, String url) {
        super();
        this.title = title;
        this.url = url;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
