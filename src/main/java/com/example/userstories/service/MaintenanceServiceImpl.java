package com.example.userstories.service;

import com.example.userstories.entity.Computer;
import com.example.userstories.entity.Loan;
import com.example.userstories.entity.Maintenance;
import com.example.userstories.repository.ComputerRepository;
import com.example.userstories.repository.MaintenanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final ComputerRepository computerRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, ComputerRepository computerRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.computerRepository = computerRepository;
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance getById(Integer id) {
        Optional<Maintenance> optionalMaintenance = maintenanceRepository.findById(id);
        return optionalMaintenance.orElse(null);
    }

    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance update(Integer id, Maintenance maintenance) {
        if (maintenanceRepository.existsById(id)) {
            maintenance.setId(id);
            return maintenanceRepository.save(maintenance);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Maintenance createAndAssign(int computer_id, Maintenance maintenance) {
        Computer computer = computerRepository.findById(computer_id)
                .orElseThrow(() -> new RuntimeException("Computer not found"));
        maintenance.setComputer(computer);
        System.out.println(maintenance.getComputer().getId());
        computer.getMaintenances().add(maintenance);
        //because cascade relationship (maintenance can't exist without computer), only the computer has to be saved
        computerRepository.save(computer);

        return maintenance;
    }
}