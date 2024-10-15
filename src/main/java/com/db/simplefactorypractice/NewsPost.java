package com.db.simplefactorypractice;

import java.time.LocalDate;

public class NewsPost extends Post{
    LocalDate newsDate;

    public LocalDate getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(LocalDate newsDate) {
        this.newsDate = newsDate;
    }
}
