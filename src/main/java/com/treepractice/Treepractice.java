package com.treepractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Treepractice {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            data=value;
            this.left=null;
            this.right=null;
        }
    }



    public static void main(String[] args) {
        TreeNode root=null;
        root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);

        //printInorder(root);
        //List<Integer> res =printInorderIterative(root);
        //res.forEach(System.out::println);

//        List<Integer> preorder = printPreOrderIterative(root);
//        preorder.forEach(System.out::println);
//        System.out.println("***************");
//        preorderRecursive(root);

        List<Integer> postorder = printPostOrderIterative(root);
        postorder.forEach(System.out::println);
        System.out.println("***************");
        postorderRecursive(root);


    }

    private static List<Integer> printPostOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            stack1.add(root);
            if(root.left!=null) stack.push(root.left);
            if(root.right!=null) stack.push(root.right);


        }
        while (!stack1.isEmpty()){
            res.add(stack1.pop().data);
        }

        return res;

    }

    private static void postorderRecursive(TreeNode root) {
        if(root==null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.println(root.data);
    }

    private static void preorderRecursive(TreeNode root) {
        if(root==null) return ;
        System.out.println(root.data);
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    private static List<Integer> printPreOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        //TreeNode curr = root;

        if(root==null) return res;
        stack.push(root);

        while(!stack.isEmpty()){
            root=stack.pop();
            res.add(root.data);
            if(root.right!=null) stack.push(root.right);
            if(root.left!=null) stack.push(root.left);
            //curr=stack.pop();
        }




        return res;
    }

    private static List<Integer> printInorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer>  res = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()) {
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            res.add(curr.data);
            curr=curr.right;
        }
        return res;
    }

    private static void printInorder(TreeNode root) {
    if(root==null) return;
        System.out.println(root.data);
        printInorder(root.left);
        printInorder(root.right);
    }
}
