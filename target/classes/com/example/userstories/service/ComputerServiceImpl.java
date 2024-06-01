package com.example.userstories.service;

import com.example.userstories.entity.Computer;
import com.example.userstories.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public List<Computer> getAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computer getById(Integer id) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        return optionalComputer.orElse(null);
    }

    @Override
    public Computer create(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public Computer update(Integer id, Computer computer) {
        if (computerRepository.existsById(id)) {
            computer.setId(id);
            return computerRepository.save(computer);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        computerRepository.deleteById(id);
    }
}
