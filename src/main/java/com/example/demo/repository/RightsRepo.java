package com.example.demo.repository;

import com.example.demo.entity.RightsEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RightsRepo extends CrudRepository<RightsEntity, Long> {
  @Query(value = "SELECT r FROM rights r WHERE r.name = ?1", nativeQuery = true)
  RightsEntity findByName(String name);
}
