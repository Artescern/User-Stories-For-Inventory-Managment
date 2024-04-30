package com.example.userstories.controller;

import com.example.userstories.entity.Loan;
import com.example.userstories.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAll() {
        List<Loan> loans = loanService.getAll();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody Loan loan) {
        loan = loanService.create(loan);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Loan> getById(@PathVariable("id") Integer id) {
        Loan loan = loanService.getById(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Loan> update(@PathVariable("id") Integer id, @RequestBody Loan loanDetail){
        loanDetail = loanService.update(id, loanDetail);
        return new ResponseEntity<>(loanDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        loanService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
