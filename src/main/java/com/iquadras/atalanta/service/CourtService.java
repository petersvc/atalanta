package com.iquadras.atalanta.service;

import com.iquadras.atalanta.domain.dto.court.DtoCourt;
import com.iquadras.atalanta.domain.entity.Court;
import com.iquadras.atalanta.repository.CourtRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CourtService {

  private final CourtRepository courtRepository;
  private static final String NOT_FOUND = "Quadra não encontrada";

  public CourtService(CourtRepository courtRepository) {
    this.courtRepository = courtRepository;
  }

  public void createCourt(DtoCourt dtoCourt) {
    Court newCourt = new Court();
    BeanUtils.copyProperties(dtoCourt, newCourt);
    courtRepository.save(newCourt);
  }

  public Court getCourt(Long id) {
    return courtRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(NOT_FOUND));
  }

  public List<Court> getAllCourts() {
    return new ArrayList<>(courtRepository.findAll());
  }

  public Court updateCourt(Long id, DtoCourt dtoCourt) {
    Court court = courtRepository.findById(id).orElseThrow(() -> new RuntimeException(NOT_FOUND));
    BeanUtils.copyProperties(dtoCourt, court);
    return courtRepository.save(court);
  }

  public void deleteCourt(Long id) {
    Court court = courtRepository.findById(id).orElseThrow(() -> new RuntimeException(NOT_FOUND));
    courtRepository.delete(court);
  }

}