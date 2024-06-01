package com.example.userstories.service;

import com.example.userstories.entity.Computer;
import java.util.List;

public interface ComputerService {
    Computer create(Computer computer);
    Computer getById(Integer id);
    List<Computer> getAll();
    Computer update(Integer id, Computer computerDetail);
    void delete(Integer id);
}