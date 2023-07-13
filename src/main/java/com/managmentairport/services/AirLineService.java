package com.managmentairport.services;

import com.managmentairport.datos.AirLineData;
import com.managmentairport.entities.AirLine;

import java.util.List;

public class AirLineService extends AirLineData implements AirLineCRUD {


    @Override
    public List<AirLine> findAll() {
        return airLines;
    }

    @Override
    public AirLine search(String name) {
        for(AirLine airLine: airLines){
            if(airLine.getAirLineName().equals(name)){
               return airLine;
            }
        }
        return null;
    }

    @Override
    public AirLine find(int id) {
        return airLines.get(id);
    }

    @Override
    public AirLine save(AirLine airline) {
        airLines.add(airline);
        return airline;
    }

    @Override
    public void delete(int id) {
            airLines.remove(id);
    }
}
