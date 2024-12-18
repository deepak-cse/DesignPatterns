package com.lld.stackOverFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable,Commentable{

   int id;
   String content;
   User author;
   Question question;
   boolean isAccepted;
   Date creationDate;
   List<Comment> comments;
   List<Vote> votes;

    public Answer( User author, Question question, String content) {
        this.id = generatedId();
        this.content = content;
        this.author = author;
        this.question = question;
        isAccepted=false;
        this.creationDate = new Date();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    private int generatedId() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public void markAsAccepted(){
        if(isAccepted){
            throw new IllegalStateException("The answer is already accepted");
        }
        isAccepted=true;
        author.updateReputation(15);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public void vote(User user, int value) {
        if(value!=1 && value!=-1){
            throw new IllegalArgumentException("Value should 1 or -1");
        }

        votes.removeIf(v->v.getUser().equals(user));
        votes.add(new Vote(user,value));
        author.updateReputation(value*10);

    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }
}
