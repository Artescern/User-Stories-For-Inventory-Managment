package com.example.userstories.controller;

import com.example.userstories.entity.Loan;
import com.example.userstories.entity.Maintenance;
import com.example.userstories.service.MaintenanceService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAll() {
        List<Maintenance> maintenances = maintenanceService.getAll();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getById(@PathVariable("id") Integer id) {
        Maintenance maintenance = maintenanceService.getById(id);
        if (maintenance != null) {
            return new ResponseEntity<>(maintenance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance maintenance) {
        Maintenance createdMaintenance = maintenanceService.create(maintenance);
        return new ResponseEntity<>(createdMaintenance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable("id") Integer id, @RequestBody Maintenance maintenanceDetail) {
        Maintenance updatedMaintenance = maintenanceService.update(id, maintenanceDetail);
        if (updatedMaintenance != null) {
            return new ResponseEntity<>(updatedMaintenance, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        maintenanceService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/appendMaintenance/{id}")
    public ResponseEntity updateMaintenances(@PathVariable("id") java.lang.Integer id, @RequestBody Maintenance maintenance) {
        maintenanceService.createAndAssign(id, maintenance);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}