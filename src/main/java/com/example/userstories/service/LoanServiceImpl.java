package com.example.userstories.service;

import com.example.userstories.entity.Computer;
import com.example.userstories.entity.Loan;
import com.example.userstories.repository.ComputerRepository;
import com.example.userstories.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final ComputerRepository computerRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, ComputerRepository computerRepository) {
        this.loanRepository = loanRepository;
        this.computerRepository = computerRepository;
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
    @Override
    @Transactional
    public Loan createAndAssign(int computer_id, Loan loan) {
        Computer computer = computerRepository.findById(computer_id)
                .orElseThrow(() -> new RuntimeException("Computer not found"));
        loan.setComputer(computer);
        computer.getLoans().add(loan);
        //because cascade relationship (loan can't exist without computer), only the computer has to be saved
        computerRepository.save(computer);

        return loan;
    }
}