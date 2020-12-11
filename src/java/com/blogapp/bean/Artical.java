package com.blogapp.bean;

public class Artical {

    private int id;
    private String author;
    private String heading;
    private String subheading;
    private String body;

    public Artical() {}

    public Artical(int id, String author, String heading, String subheading, String body){
        this.id = id;
        this.author = author;
        this.heading = heading;
        this.subheading = subheading;
        this.body = body;
    }

    public int getId(){
        return id;
    }

    public String getAuthor(){
        return author;
    }

    public String getHeading(){
        return heading;
    }

    public String getSubheading() {
        return subheading;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {
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

    public void setBody(String body) {
        this.body = body;
    }
}
