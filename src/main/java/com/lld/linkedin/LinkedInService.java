package com.lld.linkedin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedInService {

    private static LinkedInService instance;

    private final Map<String,User> users;

    private final Map<String,JobPosting> jobPostings;

    private final Map<String, List<Notification>> notifications;


    public static synchronized LinkedInService getInstance(){
        if(instance==null){
            instance = new LinkedInService();
        }
        return instance;
    }

    private LinkedInService() {
        users = new ConcurrentHashMap<>();
        jobPostings = new ConcurrentHashMap<>();
        notifications = new ConcurrentHashMap<>();
    }


    public void registerUser(User user) { users.put(user.getId(), user);}

    public void updateProfile(User user) { users.put(user.getId(),  user);}

    public User loginUser(String email, String password) {
        for(User user : users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }

        return null;
    }

    public void sendConnectionRequest(User sender, User receiver){
        Connection connection = new Connection(sender, new Timestamp(System.currentTimeMillis()));
        receiver.getConnections().add(connection);
        Notification notification = new Notification(generateNotificationId(),receiver,
                NotificationType.CONNECTION_REQUEST,"Please accept as friend",
                new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(),notification);
    }

    public void acceptConnectionRequest(User user, User connectionUser){
        for(Connection connection : user.getConnections()){
           //accept user logic
        }
    }

    public List<User> searchUser(String keyword){
        List<User> searchedUsers = new ArrayList<>();
        for(User user: users.values()){
            if(user.getName().contains(keyword)) {
                searchedUsers.add(user);
            }
        }
        return searchedUsers;
    }

    public void createJobPosting(JobPosting jobPosting){
        jobPostings.put(jobPosting.getId(),jobPosting);
        for(User user : users.values()){
            Notification notification = new Notification(generateNotificationId(),user,NotificationType.JOB_POSTING,"new job",new Timestamp(System.currentTimeMillis()));
            addNotification(user.getId(),notification);
        }
    }

    public List<JobPosting> searchJobPosting(String keyword){
        List<JobPosting> jobs = new ArrayList<>();
        for(JobPosting jobPosting : jobPostings.values()){
            if(jobPosting.getDescription().contains(keyword) || jobPosting.getTitle().contains(keyword)){
                jobs.add(jobPosting);
            }

        }

        return jobs;
    }

    public void sendMessage(User sender, User receiver, String content){
        Message message = new Message(UUID.randomUUID().toString(),receiver,sender,content,new Timestamp(System.currentTimeMillis()));
        receiver.getInbox().add(message);
        sender.getSentMessage().add(message);
        Notification notification = new Notification(generateNotificationId(), receiver,
                NotificationType.MESSAGE, "New message from " + sender.getName(),
                new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(), notification);

    }


    private void addNotification(String receiverId, Notification notification) {
        notifications.computeIfAbsent(receiverId, k-> new CopyOnWriteArrayList<>()).add(notification);
    }

    private String generateNotificationId() {
        return UUID.randomUUID().toString();
    }


    public List<Notification> getNotifications(String userId) {
        return notifications.getOrDefault(userId, new ArrayList<>());
    }







}
