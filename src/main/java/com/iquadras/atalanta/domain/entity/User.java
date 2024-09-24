package com.iquadras.atalanta.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
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
@Table(name = "T_USER")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String email;
  private String password;
  private String phone;
  private String imageUrl;
//
//  @OneToMany(mappedBy = "user")
//  private List<Booking> bookingList = new ArrayList<>();
//
//  public void addBooking(Booking newBooking) {
//        this.bookingList.add(newBooking);
//    }
    
}
