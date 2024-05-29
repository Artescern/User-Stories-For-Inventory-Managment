package com.example.userstories.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    @JsonBackReference
    private Computer computer;

    private Date date;

    private String description;

//    @OneToMany(mappedBy = "maintenance", cascade = CascadeType.ALL)
//    private List<Software> software;
//
//    public List<Software> getSoftware() {
//        return software;
//    }
//
//    public void setSoftware(List<Software> software) {
//        this.software = software;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
