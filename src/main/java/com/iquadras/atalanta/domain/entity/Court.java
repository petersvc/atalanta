package com.iquadras.atalanta.domain.entity;

import com.iquadras.atalanta.util.Sports;
import com.iquadras.atalanta.util.CourtType;

import java.util.ArrayList;

public class Court {
    private Long courtId;
    private String courtName;
    private ArrayList<Sports> courtSports;
    private CourtType courtType;

    // Getters and Setters
    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public ArrayList<Sports> getCourtSports() {
        return courtSports;
    }

    public void setCourtSports(ArrayList<Sports> courtSports) {
        this.courtSports = courtSports;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }
    
    
}
