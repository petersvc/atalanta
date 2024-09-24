package com.iquadras.atalanta.domain.entity;

import com.iquadras.atalanta.util.Sports;
import com.iquadras.atalanta.util.CourtType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.List;
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
    private Long id;

    private String name;
    private String phone;
    private double price;
    private String description;
    private String latitude;
    private String longitude;

    @ElementCollection
    @CollectionTable(name = "court_sports", joinColumns = @JoinColumn(name = "court_id"))
    @Enumerated(EnumType.STRING)
    private List<Sports> sports;

    @Enumerated(EnumType.STRING)
    private CourtType type;

    private int capacity;
    private double score;
    private String imageUrl;
    private String address;
}