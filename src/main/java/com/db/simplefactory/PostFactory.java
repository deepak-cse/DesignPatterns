package com.db.simplefactory;

/**
 * This class acts as a simple factory for creation of 
 * different posts on web site.
 *
 */
public class PostFactory {
	
	public static Post createPost(String type) {
		
		switch (type) {
		case "BlogPost" : 
			return new BlogPost();
		case "NewsPost" :
			return new NewsPost();	
		default :
			return new ProductPost();
		
		}
		
		
	}

}
