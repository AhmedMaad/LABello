package com.example.labello.profile;

public class Customer {

    private String userID;
    private String username;
    private String phone;
    private String email;
    private String profilePicture;

    public Customer(String userID, String username, String phone, String email, String profilePicture) {
        this.userID = userID;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
