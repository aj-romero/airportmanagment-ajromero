package com.managmentairport.services;

import java.util.List;

public interface IListActions<T> {
  public List<T> findAll();

  public T find(int id);
}
