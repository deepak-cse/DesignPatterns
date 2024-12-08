package com.lld.taskmanagementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private static TaskManager instance;

    Map<String, Task> tasks;
    Map<String, List<Task>> userTasks;
    private TaskManager(){
        tasks= new ConcurrentHashMap<>();
        userTasks = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance(){
        if(instance==null){
            instance=new TaskManager();
        }
        return instance;
    }

   public void createTask(Task task){
        tasks.put(task.getId(),task);
        assignTaskToUser(task.getAssignedUser(),task);
   }

   public List<Task> searchTasks(String keyword){
        List<Task> matchingTasks = new ArrayList<>();
        for(Task task:tasks.values()){
            if(task.getTitle().contains(keyword) || task.getDescription().contains(keyword)){
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
   }

    public void updateTask(Task updatedTask) {
        Task existingTask = tasks.get(updatedTask.getId());
        if (existingTask != null) {
            synchronized (existingTask) {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setDueDate(updatedTask.getDueDate());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setTaskStatus(updatedTask.getTaskStatus());
                User previousUser = existingTask.getAssignedUser();
                User newUser = updatedTask.getAssignedUser();
                if (!previousUser.equals(newUser)) {
                    unassignTaskFromUser(previousUser, existingTask);
                    assignTaskToUser(newUser, existingTask);
                }
            }
        }
    }

   public List<Task> filterTasks(TaskStatus status, Date startDate, Date endDate, int priority){
        List<Task> filterTasks = new ArrayList<>();
        for(Task task : tasks.values()){
            if(task.getTaskStatus()==status|| task.getDueDate().compareTo(startDate)>=0
             ||task.getDueDate().compareTo(endDate)<=0
            ||task.getPriority()==priority){
                filterTasks.add(task);
            }
        }

        return filterTasks;
   }


   public void markTaskAsCompleted(String taskId){
        Task task = tasks.get(taskId);
        if(task!=null){
            synchronized (task){
                task.setTaskStatus(TaskStatus.COMPLETED);
            }
        }
   }

   public List<Task> getTaskHistory(User user){
        return new ArrayList<>(userTasks.getOrDefault(user.getId(),new ArrayList<>()));
   }


   private void assignTaskToUser(User user,Task task){
        userTasks.computeIfAbsent(user.getId(),k-> new CopyOnWriteArrayList<>()).add(task);
   }

   private void unassignTaskFromUser(User user, Task task){
        List<Task> tasks = userTasks.get(user.getId());
        if(tasks!=null){
            tasks.remove(task);
        }
   }

    public void deleteTask(String taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            unassignTaskFromUser(task.getAssignedUser(), task);
        }
    }

}
