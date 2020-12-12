package com.blog.bean;

public class ArticleInformation {

    private long id;
    private String heading;
    private String subheading;

    public void setId(long id) {
        this.id = id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public long getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getSubheading() {
        return subheading;
    }
}
