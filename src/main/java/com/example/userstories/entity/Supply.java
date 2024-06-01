package com.example.userstories.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supplies")
public class Supply extends Item {
    private String sku;

    private int quantityInStock;

    private String unit;

    private String buildingLocation;

    private String floor;

    private String lockerArea;

    private int reorderLevel;

    private int reorderQuantity;

    private int leadTimeForReorder;

    private String vendor;

    private double estimatedCost;

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getLeadTimeForReorder() {
        return leadTimeForReorder;
    }

    public void setLeadTimeForReorder(int leadTimeForReorder) {
        this.leadTimeForReorder = leadTimeForReorder;
    }

    public int getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getLockerArea() {
        return lockerArea;
    }

    public void setLockerArea(String lockerArea) {
        this.lockerArea = lockerArea;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuildingLocation() {
        return buildingLocation;
    }

    public void setBuildingLocation(String buildingLocation) {
        this.buildingLocation = buildingLocation;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}