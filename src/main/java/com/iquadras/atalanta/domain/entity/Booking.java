package com.iquadras.atalanta.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne // Define o relacionamento Many-to-One com User
    private User user;

    @ManyToOne
    @JoinColumn(name = "COURT_ID")
    private Court court;

    private String date; // Atributo para armazenar o dia
    private String startTime; // Atributo para armazenar a hora
    private int durationHours;

}
