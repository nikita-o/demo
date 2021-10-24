package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity registration(@RequestBody UserEntity user) {
    try {
      userService.registration(user);
      return ResponseEntity.ok("Success registration!");
    } catch (UserAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("ERROR...");
    }
  }

  @GetMapping
  public ResponseEntity getOneUser(@RequestParam Long id) {
    try {
      return ResponseEntity.ok(userService.getOne(id));
    } catch (UserNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }

  @PatchMapping
  public ResponseEntity updateUser(@RequestParam Long id, @RequestBody UserEntity user) {
    try {
      userService.updateUser(id, user);
      return ResponseEntity.ok("Успешно обновлен");
    } catch (UserNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUser(@PathVariable Long id) {
    try {
      userService.deleteUser(id);
      return ResponseEntity.ok("Успешно удален");
    } catch (UserNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }
}
