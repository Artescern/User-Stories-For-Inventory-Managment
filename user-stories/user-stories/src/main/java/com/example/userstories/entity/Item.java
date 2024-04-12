package com.example.userstories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date purchaseDate;
    private Date lendingStartDate;
    private Date lendingEndDate;
    private String grantIssuer;
    private String assetNumber;
    private String serialNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    private String description;
    private Date maintenanceDate;
    private String storageLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getLendingStartDate() {
        return lendingStartDate;
    }

    public void setLendingStartDate(Date lendingStartDate) {
        this.lendingStartDate = lendingStartDate;
    }

    public Date getLendingEndDate() {
        return lendingEndDate;
    }

    public void setLendingEndDate(Date lendingEndDate) {
        this.lendingEndDate = lendingEndDate;
    }

    public String getGrantIssuer() {
        return grantIssuer;
    }

    public void setGrantIssuer(String grantIssuer) {
        this.grantIssuer = grantIssuer;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}
