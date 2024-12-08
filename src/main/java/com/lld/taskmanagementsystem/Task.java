package com.lld.taskmanagementsystem;

import java.util.Date;

public class Task {

    String id;
    String title;
    String description;
    Date dueDate;
    int priority;
    TaskStatus taskStatus;
    User assignedUser;

    public Task(String id, String title, String description, Date dueDate, int priority, User assignedUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignedUser = assignedUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
}
