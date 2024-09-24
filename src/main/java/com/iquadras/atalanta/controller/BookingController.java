package com.iquadras.atalanta.controller;

import com.iquadras.atalanta.domain.dto.booking.DtoBooking;
import com.iquadras.atalanta.domain.entity.Booking;
import com.iquadras.atalanta.service.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
@Tag(name = "Reserva", description = "Controller para gerenciamento de reservas")
public class BookingController {

  private final BookingService bookingService;

  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<Booking> createBooking(@RequestBody @Valid DtoBooking dtoBooking) {
    System.out.println("id do usuario: " + dtoBooking.userId());
    System.out.println("id da quadra: " + dtoBooking.courtId());
    System.out.println("data: " + dtoBooking.date());
    System.out.println("hora de inicio: " + dtoBooking.startTime());
    System.out.println("duracao: " + dtoBooking.durationHours());

    var booking = bookingService.createBooking(dtoBooking);
    System.out.println("Reserva criada com sucesso2222");
    return ResponseEntity.status(HttpStatus.CREATED).body(booking);
  }

  @GetMapping
  public ResponseEntity<List<Booking>> getAllBookings() {
    var bookings = bookingService.getAllBookings();
    return ResponseEntity.status(HttpStatus.OK).body(bookings);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
    var booking = bookingService.getBooking(id);
    return ResponseEntity.status(HttpStatus.OK).body(booking);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody @Valid DtoBooking dtoBooking) {
    var booking = bookingService.updateBooking(id, dtoBooking);
    return ResponseEntity.status(HttpStatus.OK).body(booking);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
    bookingService.deleteBooking(id);
    return ResponseEntity.status(HttpStatus.OK).body("Reserva deletada com sucesso");
  }

}