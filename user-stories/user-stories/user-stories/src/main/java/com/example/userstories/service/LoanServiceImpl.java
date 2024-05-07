package com.example.userstories.service;

import com.example.userstories.entity.Loan;
import com.example.userstories.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getById(Integer id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        return optionalLoan.orElse(null);
    }

    @Override
    public Loan create(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan update(Integer id, Loan loan) {
        if (loanRepository.existsById(id)) {
            loan.setId(id);
            return loanRepository.save(loan);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        loanRepository.deleteById(id);
    }
}
