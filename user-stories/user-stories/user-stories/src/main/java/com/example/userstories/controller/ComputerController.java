package com.example.userstories.controller;

import com.example.userstories.entity.Computer;
import com.example.userstories.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computers")
public class ComputerController {

    private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    public ResponseEntity<List<Computer>> getAll() {
        List<Computer> computers = computerService.getAll();
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> getById(@PathVariable("id") Integer id) {
        Computer computer = computerService.getById(id);
        if (computer != null) {
            return new ResponseEntity<>(computer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Computer> create(@RequestBody Computer computer) {
        Computer createdComputer = computerService.create(computer);
        return new ResponseEntity<>(createdComputer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> update(@PathVariable("id") Integer id, @RequestBody Computer computerDetail) {
        Computer updatedComputer = computerService.update(id, computerDetail);
        if (updatedComputer != null) {
            return new ResponseEntity<>(updatedComputer, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        computerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
