package com.example.userstories.controller;

import com.example.userstories.entity.Maintenance;
import com.example.userstories.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenances")
public class MaintenanceController {
    private MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAll() {
        List<Maintenance> maintenances = maintenanceService.getAll();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance maintenance) {
        maintenance = maintenanceService.create(maintenance);
        return new ResponseEntity<>(maintenance, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Maintenance> getById(@PathVariable("id") Integer id) {
        Maintenance maintenance = maintenanceService.getById(id);
        return new ResponseEntity<>(maintenance, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Maintenance> update(@PathVariable("id") Integer id, @RequestBody Maintenance maintenanceDetail){
        maintenanceDetail = maintenanceService.update(id, maintenanceDetail);
        return new ResponseEntity<>(maintenanceDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        maintenanceService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
