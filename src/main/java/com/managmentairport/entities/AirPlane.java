package com.managmentairport.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AirPlane {
    private AirLine airLine;
    private AirPlaneState state;
    private String registerNumber;
    private int capacity;
}
