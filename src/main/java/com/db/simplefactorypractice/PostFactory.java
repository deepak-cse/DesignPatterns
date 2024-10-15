package com.db.simplefactorypractice;

import com.db.simplefactorypractice.NewsPost;

public class PostFactory {

    public static Post getPostObject (PostType type) {
        if(type.getPost().equals("newspost")) return new NewsPost();
        else if(type.getPost().equals("blogpost")) return new BlogPost();
        else return null;
    }
}
