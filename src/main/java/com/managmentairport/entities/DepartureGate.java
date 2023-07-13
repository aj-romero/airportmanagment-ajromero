package com.managmentairport.entities;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartureGate {
    private AirPlane airPlane;
    private Gate gate;
    private boolean departure = false;
}
