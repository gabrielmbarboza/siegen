package com.gabrielmbarboza.sienge.dto;

public class TransportTotalCost {
    private String vehicle;
    private Double pavedLandCost = 0.0d;
    private Double unpavedLandCost = 0.0d;
    private Double weightCargo = 0.0d;
    private Double totalCost = 0.0d;

    public TransportTotalCost(String vehicle, Double pavedLandCost,
            Double unpavedLandCost, Double weightCargo, Double totalCost) {
        this.vehicle = vehicle;
        this.pavedLandCost = pavedLandCost;
        this.unpavedLandCost = unpavedLandCost;
        this.weightCargo = weightCargo;
        this.totalCost = totalCost;
    }

    public String getVehicle() {
        return this.vehicle;
    }

    public String getPavedLandCost() {
        return String.format("%.2f", this.pavedLandCost);
    }

    public String getUnpavedLandCost() {
        return String.format("%.2f", this.unpavedLandCost);
    }

    public String getTotalCost() {
        return String.format("%.2f", this.totalCost);
    }

    public String getWeightCargo() {
        return String.format("%.2f", this.weightCargo);
    }
}
