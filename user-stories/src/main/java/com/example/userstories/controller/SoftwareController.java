package com.example.userstories.controller;

import com.example.userstories.entity.Software;
import com.example.userstories.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software")
public class SoftwareController {

    private final SoftwareService softwareService;

    @Autowired
    public SoftwareController(SoftwareService softwareService) {
        this.softwareService = softwareService;
    }

    @GetMapping
    public ResponseEntity<List<Software>> getAll() {
        List<Software> softwareList = softwareService.getAll();
        return new ResponseEntity<>(softwareList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Software> getById(@PathVariable("id") Integer id) {
        Software software = softwareService.getById(id);
        if (software != null) {
            return new ResponseEntity<>(software, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Software> create(@RequestBody Software software) {
        Software createdSoftware = softwareService.create(software);
        return new ResponseEntity<>(createdSoftware, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Software> update(@PathVariable("id") Integer id, @RequestBody Software softwareDetail) {
        Software updatedSoftware = softwareService.update(id, softwareDetail);
        if (updatedSoftware != null) {
            return new ResponseEntity<>(updatedSoftware, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        softwareService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
