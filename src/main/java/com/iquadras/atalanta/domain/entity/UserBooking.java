package com.iquadras.atalanta.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_USER_BOOKING")
public class UserBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userBookingId;

    private LocalDateTime startTime;
    private int durationHours;

    @ManyToOne
    @JoinColumn(name = "COURT_ID")
    private Court court;

    @ManyToOne // Define o relacionamento Many-to-One com User
    private User user;

}
