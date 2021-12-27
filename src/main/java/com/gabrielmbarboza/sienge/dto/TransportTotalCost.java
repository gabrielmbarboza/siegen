package com.gabrielmbarboza.sienge.dto;

public class TransportTotalCost {
    private String vehicle;
    private int kmByPavedLand = 0;
    private int kmByUnpavedLand = 0;
    private int weightCargo = 0;
    private Double totalCost = 0.0d;

    public TransportTotalCost(String vehicle, int kmByPavedLand,
            int kmByUnpavedLand, int weightCargo, Double totalCost) {
        this.vehicle = vehicle;
        this.kmByPavedLand = kmByPavedLand;
        this.kmByUnpavedLand = kmByUnpavedLand;
        this.weightCargo = weightCargo;
        this.totalCost = totalCost;
    }

    public String getVehicle() {
        return this.vehicle;
    }

    public int getKmByPavedLand() {
        return kmByPavedLand;
    }

    public int getKmByUnpavedLand() {
        return this.kmByUnpavedLand;
    }

    public String getTotalCost() {
        return String.format("%.2f", this.totalCost);
    }

    public int getWeightCargo() {
        return this.weightCargo;
    }
}
