package com.db.simplefactorypractice;

public class Client {
    public static void main(String[] args) {
        Post post = PostFactory.getPostObject(PostType.NEWSPOST);
        post.setPostId("deepak");
        System.out.println(post.postId);
    }
}
