package com.example.userstories.service;

import com.example.userstories.entity.Loan;
import java.util.List;

public interface LoanService {
    Loan create(Loan loan);
    Loan getById(Integer id);
    List<Loan> getAll();
    Loan update(Integer id, Loan loanDetail);
    void delete(Integer id);
}
