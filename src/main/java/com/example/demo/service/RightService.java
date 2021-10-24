package com.example.demo.service;

import com.example.demo.entity.RightsEntity;
import com.example.demo.exceptions.RightAlreadyExistException;
import com.example.demo.exceptions.RightNotFoundException;
import com.example.demo.models.Right;
import com.example.demo.repository.RightsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RightService {

  @Autowired
  private RightsRepo rightsRepo;

  public RightsEntity create(RightsEntity entity) throws RightAlreadyExistException {
    if (rightsRepo.findByName(entity.getName()) != null) {
      throw new RightAlreadyExistException("message");
    }
    return rightsRepo.save(entity);
  }

  public Right getOne(Long id) throws RightNotFoundException {
    RightsEntity entity = rightsRepo.findById(id).get();
    if (entity == null) {
      throw new RightNotFoundException("message");
    }
    return Right.toModel(entity);
  }

  public RightsEntity update(Long id, RightsEntity right) throws RightNotFoundException {
    RightsEntity entity = rightsRepo.findById(id).get();
    if (entity == null) {
      throw new RightNotFoundException("message");
    }

    if (right.getName() != null)
      entity.setName(right.getName());
    if (right.get_create() != null)
      entity.set_create(right.get_create());
    if (right.get_delete() != null)
      entity.set_delete(right.get_delete());
    if (right.get_read() != null)
      entity.set_read(right.get_read());
    if (right.get_update() != null)
      entity.set_update(right.get_update());

    return rightsRepo.save(entity);
  }

  public void delete(Long id) throws RightNotFoundException {
    if (!rightsRepo.existsById(id)) {
      throw new RightNotFoundException("message");
    }
    rightsRepo.deleteById(id);
  }

}
