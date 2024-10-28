package com.collections;

import java.util.*;

public class PracticeCollections {
    public static void main(String[] args) {
        //practice all collections


        //list
        // 1. ArrayList
        //2. LinkedList



        //stack
        //normal stack
        Stack<Integer> stack = new Stack<>();
        //push and pop methods
        stack.push(1);
        stack.pop();

        //queue

        Queue<Integer> queue = new LinkedList<>();
        //add and poll
        queue.add(5);
        queue.peek();
        queue.poll();

        //heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1-o2);


        //hashmap
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"deepak");

        //hash set
        HashSet<Integer> set = new HashSet<>();

        //miscellaneous


    }
}
