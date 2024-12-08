package com.lld.stackOverFlow;

import java.util.ArrayList;
import java.util.List;

public class User {

    int id;
    String username;
    String email;
    int reputation;
    List<Question> questions;
    List<Answer> answers;
    List<Comment> comments;

    private static final int QUESTION_REPUTATION=5;
    private static final int ANSWER_REPUTATION=10;
    private static final int COMMENT_REPUTATION=2;


    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.reputation=0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags){
        Question question = new Question(this,title, content,tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content){
        Answer answer = new Answer(this,question,content);
        answers.add(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content){
        Comment comment = new Comment(this,content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public void updateReputation(int value) {
        this.reputation+=value;
        if(reputation<0){
            this.reputation=0;
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}