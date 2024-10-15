package com.db.builder.practice;

public class User {
    private String firstname;
    private String lastname;
    private String middlename;
    private String pincode;
    private String landmark;
    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", pincode='" + pincode + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static UserBuilder getUserBuilder() { return new UserBuilder();}

     static class UserBuilder {
        private String firstname;
        private String lastname;
        private String middlename;
        private String pincode;
        private String landmark;
        private String city;
        private String state;
        private String country;

        public UserBuilder withFirstName(String firstName){
            this.firstname=firstName;
            return this;

        }

        public UserBuilder withlastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder withmiddlename(String middlename) {
            this.middlename=middlename;
            return this;
        }

        public UserBuilder withCity(String city){
            this.city = city;
            return this;
        }


        public User build(){
            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setMiddlename(middlename);
            user.setCity(city);
            return user;
        }


    }



}
