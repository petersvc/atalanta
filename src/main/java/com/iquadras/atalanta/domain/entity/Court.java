package com.iquadras.atalanta.domain.entity;

import com.iquadras.atalanta.util.Sports;
import com.iquadras.atalanta.util.CourtType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_COURT")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courtId;
    private String courtName;
    private ArrayList<Sports> courtSports;
    private CourtType courtType;
    
}
