package com.managmentairport.services;

import com.managmentairport.datos.DepartureGateData;
import com.managmentairport.entities.DepartureGate;
import com.managmentairport.entities.Gate;

import java.util.List;

public class DepartureGateService extends DepartureGateData implements DepartureGateCRUD {
    @Override
    public List<DepartureGate> findAll() {
        return departureGates;
    }

    @Override
    public DepartureGate findByGate(Gate gate) {
        DepartureGate res = null;
        for( DepartureGate departureGate: departureGates){
            if(!departureGate.isDeparture() && departureGate.getGate().equals(gate)){
                res = departureGate;
            }
        }
        return res;
    }

    public int findIdByGate(Gate gate){
        int res = 0;
        for( DepartureGate departureGate: departureGates){
            if(!departureGate.isDeparture() && departureGate.getGate().equals(gate)){
                break;
            }
            res++;
        }
        return res;
    }

    @Override
    public DepartureGate find(int id) {
        return departureGates.get(id);
    }

    @Override
    public DepartureGate save(DepartureGate departureGate) {
        departureGates.add(departureGate);
        return departureGate;
    }

    @Override
    public void update(DepartureGate departureGate, int idx) {
        departureGates.set(idx,departureGate);
    }

    @Override
    public void delete(int id) {
        departureGates.remove(id);
    }
}
