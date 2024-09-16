package com.iquadras.atalanta.controller;

import com.iquadras.atalanta.domain.dto.court.DtoCourt;
import com.iquadras.atalanta.domain.dto.user.DtoUser;
import com.iquadras.atalanta.domain.dto.user.DtoUserLogin;
import com.iquadras.atalanta.domain.dto.user.DtoUserPostResponse;
import com.iquadras.atalanta.domain.entity.Court;
import com.iquadras.atalanta.service.CourtService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/court")
@Tag(name = "Quadra", description = "Controller para gerenciamento de quadras")
public class CourtController {

  private final CourtService courtService;

  @Autowired
  public CourtController(CourtService courtService) {
    this.courtService = courtService;
  }

  @PostMapping
  public ResponseEntity<String> createCourt(@RequestBody @Valid DtoCourt dtoCourt) {
    courtService.createCourt(dtoCourt);
    return ResponseEntity.status(HttpStatus.CREATED).body("Quadra criada com sucesso");
  }

  @GetMapping
  public ResponseEntity<List<Court>> getAllCourts() {
    var courts = courtService.getAllCourts();
    return ResponseEntity.status(HttpStatus.OK).body(courts);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Court> getCourt(@PathVariable Long id) {
    var court = courtService.getCourt(id);
    return ResponseEntity.status(HttpStatus.OK).body(court);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Court> updateCourt(@PathVariable Long id, @RequestBody @Valid DtoCourt dtoCourt) {
    var court = courtService.updateCourt(id, dtoCourt);
    return ResponseEntity.status(HttpStatus.OK).body(court);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCourt(@PathVariable Long id) {
    courtService.deleteCourt(id);
    return ResponseEntity.status(HttpStatus.OK).body("Quadra deletada com sucesso");
  }

}