package com.managmentairport.services;

import com.managmentairport.datos.GateData;
import com.managmentairport.entities.AirPlaneState;
import com.managmentairport.entities.Gate;

import java.util.List;

public class GateService extends GateData implements GateCRUD {
    @Override
    public List<Gate> findAll() {
        return gates;
    }

    @Override
    public Gate search(String name) {
        for(Gate gate: gates){
            if(gate.getGateName().equals(name)){
                return gate;
            }
        }
        return null;
    }

    @Override
    public Gate find(int id) {
        return gates.get(id);
    }

    @Override
    public Gate save(Gate gate) {
        gates.add(gate);
        return gate;
    }

    @Override
    public void update(Gate gate, int idx) {
        gates.set(idx,gate);
    }

    @Override
    public void delete(int id) {
        gates.remove(id);
    }
}
