package com.example.userstories.controller;

import com.example.userstories.entity.Supply;
import com.example.userstories.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping
    public ResponseEntity<List<Supply>> getAll() {
        List<Supply> supplies = supplyService.getAll();
        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supply> getById(@PathVariable("id") Integer id) {
        Supply supply = supplyService.getById(id);
        if (supply != null) {
            return new ResponseEntity<>(supply, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Supply> create(@RequestBody Supply supply) {
        Supply createdSupply = supplyService.create(supply);
        return new ResponseEntity<>(createdSupply, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supply> update(@PathVariable("id") Integer id, @RequestBody Supply supplyDetail) {
        Supply updatedSupply = supplyService.update(id, supplyDetail);
        if (updatedSupply != null) {
            return new ResponseEntity<>(updatedSupply, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        supplyService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
