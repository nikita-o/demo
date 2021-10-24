package com.example.demo.controller;

import com.example.demo.entity.RightsEntity;
import com.example.demo.exceptions.RightAlreadyExistException;
import com.example.demo.exceptions.RightNotFoundException;
import com.example.demo.service.RightService;

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
@RequestMapping("/rights")
public class RightController {

  @Autowired
  private RightService rightService;

  @PostMapping
  public ResponseEntity createRight(@RequestBody RightsEntity right) {
    try {
      rightService.create(right);
      return ResponseEntity.ok("Success registration!");
    } catch (RightAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("ERROR...");
    }
  }

  @GetMapping
  public ResponseEntity getOne(@RequestParam Long id) {
    try {
      return ResponseEntity.ok(rightService.getOne(id));
    } catch (RightNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }

  @PatchMapping
  public ResponseEntity update(@RequestParam Long id, @RequestBody RightsEntity right) {
    try {
      rightService.update(id, right);
      return ResponseEntity.ok("Успешно обновлен");
    } catch (RightNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    try {
      rightService.delete(id);
      return ResponseEntity.ok("Успешно удален");
    } catch (RightNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }
}
