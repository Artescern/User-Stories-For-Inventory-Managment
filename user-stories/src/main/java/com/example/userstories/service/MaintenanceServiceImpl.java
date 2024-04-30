package com.example.userstories.service;

import com.example.userstories.entity.Maintenance;
import com.example.userstories.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
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
}
