package com.iquadras.atalanta.domain.entity;


import java.time.LocalDateTime;

public class UserBooking {
    private Long id;
    private LocalDateTime startTime;
    private int durationHours;
    private Court court;
    private User user;

    public UserBooking(Long id, LocalDateTime startTime, int durationHours, Court court, User user) {
        this.id = id;
        this.startTime = startTime;
        this.durationHours = durationHours;
        this.court = court;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public Court getCourt() {
        return this.court;
    }

    public void setCourt(Court newCourt) {
        this.court = newCourt;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User newUser) {
        this.user = newUser;
    }
}
