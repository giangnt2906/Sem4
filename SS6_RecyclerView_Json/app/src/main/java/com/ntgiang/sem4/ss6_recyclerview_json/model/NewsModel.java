package com.ntgiang.sem4.ss6_recyclerview_json.model;

public class NewsModel {
    private String date;
    private String title;
    private String content;
    private String image;

    public NewsModel(String date, String title, String content, String image) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
