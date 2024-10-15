package com.db.simplefactorypractice;

import java.time.LocalDate;

public class BlogPost extends Post{

    String blogSite;
    LocalDate blogTime;
    String blogTitle;

    public String getBlogSite() {
        return blogSite;
    }

    public void setBlogSite(String blogSite) {
        this.blogSite = blogSite;
    }

    public LocalDate getBlogTime() {
        return blogTime;
    }

    public void setBlogTime(LocalDate blogTime) {
        this.blogTime = blogTime;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
