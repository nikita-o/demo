package com.example.demo.models;

import com.example.demo.entity.RightsEntity;

public class Right {
  private String name;
  private Boolean _create;
  private Boolean _read;
  private Boolean _update;
  private Boolean _delete;

  public static Right toModel(RightsEntity entity) {
    Right model = new Right();
    model.setName(entity.getName());
    model.set_create(entity.get_create());
    model.set_delete(entity.get_delete());
    model.set_read(entity.get_read());
    model.set_update(entity.get_update());
    return model;
  }

  public Right() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean get_create() {
    return _create;
  }

  public void set_create(Boolean _create) {
    this._create = _create;
  }

  public Boolean get_delete() {
    return _delete;
  }

  public void set_delete(Boolean _delete) {
    this._delete = _delete;
  }

  public Boolean get_read() {
    return _read;
  }

  public void set_read(Boolean _read) {
    this._read = _read;
  }

  public Boolean get_update() {
    return _update;
  }

  public void set_update(Boolean _update) {
    this._update = _update;
  }
}
