package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Rights")
public class RightsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Boolean _create;
  private Boolean _read;
  private Boolean _update;
  private Boolean _delete;

  public RightsEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void set_create(Boolean _create) {
    this._create = _create;
  }

  public Boolean get_create() {
    return _create;
  }

  public void set_delete(Boolean _delete) {
    this._delete = _delete;
  }

  public Boolean get_delete() {
    return _delete;
  }

  public void set_read(Boolean _read) {
    this._read = _read;
  }

  public Boolean get_read() {
    return _read;
  }

  public void set_update(Boolean _update) {
    this._update = _update;
  }

  public Boolean get_update() {
    return _update;
  }

}
