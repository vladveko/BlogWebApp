package com.blog.bean;

public class ArticleInformation {

    private long id;
    private String author;
    private String heading;
    private String subheading;

    public ArticleInformation(int id, String author, String heading, String subheading) {
        this.id = id;
        this.author = author;
        this.heading = heading;
        this.subheading = subheading;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public String getHeading() {
        return heading;
    }

    public String getSubheading() {
        return subheading;
    }
}
