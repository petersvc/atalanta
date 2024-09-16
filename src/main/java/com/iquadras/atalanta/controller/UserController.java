package com.iquadras.atalanta.controller;

import com.iquadras.atalanta.domain.dto.user.DtoUser;
import com.iquadras.atalanta.domain.dto.user.DtoUserGetResponse;
import com.iquadras.atalanta.domain.dto.user.DtoUserLogin;
import com.iquadras.atalanta.domain.dto.user.DtoUserPostResponse;
import com.iquadras.atalanta.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Usuário", description = "Controller para gerenciamento/autenticação de usuários")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<DtoUserPostResponse> createUser(@RequestBody @Valid DtoUser dtoUser) {
    var user = userService.createUser(dtoUser);

    var dtoUserPostResponse = new DtoUserPostResponse(
        user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPhone());

    return ResponseEntity.status(HttpStatus.CREATED).body(dtoUserPostResponse);
  }

  @PostMapping("/login")
  public ResponseEntity<DtoUserPostResponse> userLogin(@RequestBody DtoUserLogin dtoUserLogin) {
    var user = userService.login(dtoUserLogin);

    var dtoUserPostResponse = new DtoUserPostResponse(
        user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPhone());

    return ResponseEntity.status(HttpStatus.OK).body(dtoUserPostResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DtoUserGetResponse> getUser(@PathVariable Long id) {
    var user = userService.getUser(id);

    var dtoUserGetResponse = new DtoUserGetResponse(
        user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPhone());

    return ResponseEntity.status(HttpStatus.OK).body(dtoUserGetResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DtoUserGetResponse> updateUser(@PathVariable Long id, @RequestBody DtoUser dtoUser) {
    var user = userService.updateUser(id, dtoUser);

    var dtoUserGetResponse = new DtoUserGetResponse(
        user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPhone());

    return ResponseEntity.status(HttpStatus.OK).body(dtoUserGetResponse);
  }

}