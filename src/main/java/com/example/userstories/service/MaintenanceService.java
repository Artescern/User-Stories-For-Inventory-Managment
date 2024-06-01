package com.example.userstories.service;

import com.example.userstories.entity.Loan;
import com.example.userstories.entity.Maintenance;
import java.util.List;

public interface MaintenanceService {
    Maintenance create(Maintenance maintenance);
    Maintenance getById(Integer id);
    List<Maintenance> getAll();
    Maintenance update(Integer id, Maintenance maintenanceDetail);
    void delete(Integer id);
    Maintenance createAndAssign(int computer_id, Maintenance maintenance);
}