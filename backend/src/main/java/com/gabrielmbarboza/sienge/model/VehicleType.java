package com.gabrielmbarboza.sienge.model;

public class VehicleType {
    private static Vehicle vehicle;

    public static Vehicle getVehicle(String category, String type) {
        switch (category) {
            case "TRUCK":
                vehicle = new Truck(type);
                break;
        }

        return vehicle;
    }
}