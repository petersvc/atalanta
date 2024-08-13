package com.iquadras.atalanta.controller;

import com.iquadras.atalanta.domain.dto.DtoUser;
import com.iquadras.atalanta.domain.dto.DtoUserLogin;
import com.iquadras.atalanta.domain.dto.DtoUserPostResponse;
import com.iquadras.atalanta.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Usuário", description = "Controller para gerenciamento/autenticação de usuários")
public class UserController {

  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<DtoUserPostResponse> createUser(@RequestBody @Valid DtoUser dtoUser) {

    var user = userService.createUser(dtoUser);

    var dtoUserPostResponse = new DtoUserPostResponse(
        user.getUserId(),
        user.getUserFullName(),
        user.getUserEmail(),
        user.getUserPhoneNumber());

    return ResponseEntity.status(HttpStatus.CREATED).body(dtoUserPostResponse);
  }

  @PostMapping("/login")
  public ResponseEntity<DtoUserPostResponse> userLogin(@RequestBody DtoUserLogin dtoUserLogin) {
    var user = userService.login(dtoUserLogin);

    var dtoUserPostResponse = new DtoUserPostResponse(
        user.getUserId(),
        user.getUserFullName(),
        user.getUserEmail(),
        user.getUserPhoneNumber());

    return ResponseEntity.status(HttpStatus.OK).body(dtoUserPostResponse);
  }

}