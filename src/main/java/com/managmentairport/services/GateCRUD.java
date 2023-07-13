package com.managmentairport.services;

import com.managmentairport.entities.Gate;

import java.util.List;

public interface GateCRUD {

    public List<Gate> findAll();
    public Gate search(String name);
    public Gate find(int id);
    public Gate save(Gate gate);

    public void update(Gate gate, int idx);
    public void delete(int id);
}
