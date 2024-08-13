package com.iquadras.atalanta.service;

import com.iquadras.atalanta.domain.dto.DtoUser;
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

    Optional<User> user = userRepository.findByUserEmail(dtoUser.userEmail());

    if (user.isPresent()) {
      throw new RuntimeException("Um usuário com este email já existe");
    }

    User newUser = new User();
    BeanUtils.copyProperties(dtoUser, newUser);

    return userRepository.save(newUser);

  }
}
