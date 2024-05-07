package com.example.userstories.service;

import com.example.userstories.entity.Software;
import java.util.List;

public interface SoftwareService {
    Software create(Software software);
    Software getById(Integer id);
    List<Software> getAll();
    Software update(Integer id, Software softwareDetail);
    void delete(Integer id);
}
