package com.db.simplefactorypractice;

public abstract class Post {

    String postId;
    String postTime;
    String postHeadline;
    String text;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostHeadline() {
        return postHeadline;
    }

    public void setPostHeadline(String postHeadline) {
        this.postHeadline = postHeadline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
