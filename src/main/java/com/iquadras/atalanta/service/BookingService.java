package com.iquadras.atalanta.service;

import com.iquadras.atalanta.domain.dto.booking.DtoBooking;
import com.iquadras.atalanta.domain.dto.user.DtoUser;
import com.iquadras.atalanta.domain.entity.Booking;
import com.iquadras.atalanta.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;
  private final UserService userService;
  private static final String NOT_FOUND = "Quadra não encontrada";

  public BookingService(BookingRepository bookingRepository, UserService userService) {
    this.bookingRepository = bookingRepository;
    this.userService = userService;
  }

  public void createBooking(DtoBooking dtoBooking) {
    var user = userService.getUser(dtoBooking.userId());

    Booking newBooking = new Booking();
    BeanUtils.copyProperties(dtoBooking, newBooking);
    bookingRepository.save(newBooking);

    user.addBooking(newBooking);
    DtoUser dtoUser = new DtoUser(user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
    userService.updateUser(user.getId(), dtoUser);
  }

  public Booking getBooking(Long id) {
    return bookingRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(NOT_FOUND));
  }

  public List<Booking> getAllBookings() {
    return new ArrayList<>(bookingRepository.findAll());
  }

  public Booking updateBooking(Long id, DtoBooking dtoBooking) {
    Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(NOT_FOUND));
    BeanUtils.copyProperties(dtoBooking, booking);
    return bookingRepository.save(booking);
  }

  public void deleteBooking(Long id) {
    Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(NOT_FOUND));
    bookingRepository.delete(booking);
  }

}