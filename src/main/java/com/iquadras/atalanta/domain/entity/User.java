package com.iquadras.atalanta.domain.entity;

import java.util.ArrayList;

public class User {
    private Long userId;
    private String userFullName;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;
    private ArrayList<UserBooking> userBookingList;

    public User( Long userId, String userFullName, String userEmail, String userPhone, String userPassword){
        this.userId = userId;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhone;
        this.userPassword = userPassword;
        this.userBookingList = new ArrayList<UserBooking>();
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public ArrayList<UserBooking> getUserBookingList() {
        return userBookingList;
    }
    
    public void setUserBookingList(ArrayList<UserBooking> userBookingList) {
        this.userBookingList = userBookingList;
    }

    public void addBooking(UserBooking userNewBooking) {
        this.userBookingList.add(userNewBooking);
    }
    
}
