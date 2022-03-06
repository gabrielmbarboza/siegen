package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.exception.VehicleCategoryNotFoundException;
import com.gabrielmbarboza.sienge.exception.VehicleTypeNotFoundException;

public class VehicleType {
    private String category;
    private String type;

    public VehicleType(String category, String type) {
        this.category = category;
        this.type = type;
    }

    public Vehicle getVehicle() {
        Vehicle vehicle = null;

        if (isFieldEmpty(this.category)) {
            throw new VehicleCategoryNotFoundException();
        }

        if (isFieldEmpty(this.type)) {
            throw new VehicleTypeNotFoundException();
        }

        this.category = this.category.trim().toUpperCase();
        this.type = this.type.trim().toUpperCase();

        switch (this.category) {
            case "TRUCK":
                vehicle = new Truck(this.type);
                break;
            default:
                throw new VehicleCategoryNotFoundException();
        }

        return vehicle;
    }

    private Boolean isFieldEmpty(String field) {
        return field == null || field.length() == 0;
    }
}