package com.resale.app.model.entity.view;

import java.io.Serializable;

public class NavigationLink implements Serializable {
    private String url;
    private String label;

    public NavigationLink(String url, String label, NavStatus status) {
        this.url = url;
        this.label = label;
        this.status = status;
    }

    private NavStatus status;


    public String getUrl() {
        return url;
    }

    public void setUrl(String link) {
        this.url = link;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public NavStatus getStatus() {
        return status;
    }

    public void setStatus(NavStatus status) {
        this.status = status;
    }

}