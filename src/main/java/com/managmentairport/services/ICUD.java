package com.managmentairport.services;

public interface ICUD<T> {
  public T save(T entity);

  public void delete(int id);

  public void update(int idx, T entity);
}
