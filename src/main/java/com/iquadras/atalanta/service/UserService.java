package com.iquadras.atalanta.service;

import com.iquadras.atalanta.domain.dto.user.DtoUser;
import com.iquadras.atalanta.domain.dto.user.DtoUserLogin;
import com.iquadras.atalanta.domain.entity.User;
import com.iquadras.atalanta.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(DtoUser dtoUser) {

    Optional<User> user = userRepository.findByEmail(dtoUser.email());

    if (user.isPresent()) {
      throw new RuntimeException("Um usuário com este email já existe");
    }

    User newUser = new User();
    BeanUtils.copyProperties(dtoUser, newUser);

    return userRepository.save(newUser);
  }

  public User login(DtoUserLogin dtoUserLogin) {

    Optional<User> user = userRepository.findByEmail(dtoUserLogin.email());

    if (user.isEmpty()) {
      throw new RuntimeException("Nenhum usuário encontrado com esse email.");
    }

    if (!user.get().getPassword().equals(dtoUserLogin.password())) {
      throw new RuntimeException("Senha incorreta");
    }

    return user.get();
  }

  public User getUser(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }

  public User updateUser(Long id, DtoUser dtoUser) {
    var user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    user.setName(dtoUser.name());
    user.setEmail(dtoUser.email());
    user.setPhone(dtoUser.phone());

    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    var user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    userRepository.delete(user);
  }
}