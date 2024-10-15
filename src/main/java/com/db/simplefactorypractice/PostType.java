package com.db.simplefactorypractice;

public enum PostType {
    NEWSPOST("newspost"),BLOGPOST("blogpost");

    private String post;

    public String getPost() {
        return post;
    }

    private PostType(String newspost) {
        this.post=newspost;
    }

}
