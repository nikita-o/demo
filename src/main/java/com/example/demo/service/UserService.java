package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
    if (userRepo.findByUsername(user.getUsername()) != null) {
      throw new UserAlreadyExistException("User is already!");
    }
    return userRepo.save(user);
  }

  public User getOne(Long id) throws UserNotFoundException {
    UserEntity user = userRepo.findById(id).get();
    if (user == null) {
      throw new UserNotFoundException("Пользователь не найден");
    }
    return User.toModel(user);
  }

  public void deleteUser(Long id) throws UserNotFoundException {
    if (!userRepo.existsById(id)) {
      throw new UserNotFoundException("Пользователь не найден");
    }
    userRepo.deleteById(id);
  }

  public UserEntity updateUser(Long id, UserEntity user) throws UserNotFoundException {
    UserEntity entity = userRepo.findById(id).get();
    if (entity == null) {
      throw new UserNotFoundException("Пользователь не найден");
    }
    if (user.getUsername() != null)
      entity.setUsername(user.getUsername());
    if (user.getPassword() != null)
      entity.setUsername(user.getPassword());
    return userRepo.save(entity);
  }
}
