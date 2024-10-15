package com.db.builder.practice;

public class client {
    public static void main(String[] args) {
        User user = User.getUserBuilder().withFirstName("deepak")
                .withlastname("prajapati")
                .withmiddlename("kumar")
                .withCity("jaipur")
                .build();

        System.out.println(user.toString());
    }
}
