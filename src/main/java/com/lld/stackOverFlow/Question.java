package com.lld.stackOverFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Commentable, Votable{

    private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List <Tag> tags;
    private final List<Vote> votes;


    public Question(User author, String title, String content, List<String> tagNames) {
        this.id = generatedId();
        this.author = author;
        this.content = content;
        this.title = title;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();

        for(String tagName : tagNames){
            this.tags.add(new Tag(tagName));
        }


    }

    public void addAnswer(Answer answer){
        if(!answers.contains(answer)){
            answers.add(answer);
        }
    }

    private int generatedId() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value * 5);  // +5 for upvote, -5 for downvote
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Vote> getVotes() {
        return votes;
    }

}
