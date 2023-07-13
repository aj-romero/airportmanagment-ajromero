package com.managmentairport.services;

import com.managmentairport.entities.DepartureGate;
import com.managmentairport.entities.Gate;

import java.util.List;

public interface DepartureGateCRUD {
    public List<DepartureGate> findAll();

    public DepartureGate findByGate(Gate gate);

    public DepartureGate find(int id);
    public DepartureGate save(DepartureGate departureGate);

    public void update(DepartureGate departureGate, int idx);
    public void delete(int id);
}
