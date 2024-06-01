package com.example.userstories.service;

import com.example.userstories.entity.Software;
import com.example.userstories.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareServiceImpl implements SoftwareService {

    private final SoftwareRepository softwareRepository;

    @Autowired
    public SoftwareServiceImpl(SoftwareRepository softwareRepository) {
        this.softwareRepository = softwareRepository;
    }

    @Override
    public List<Software> getAll() {
        return softwareRepository.findAll();
    }

    @Override
    public Software getById(Integer id) {
        Optional<Software> optionalSoftware = softwareRepository.findById(id);
        return optionalSoftware.orElse(null);
    }

    @Override
    public Software create(Software software) {
        return softwareRepository.save(software);
    }

    @Override
    public Software update(Integer id, Software software) {
        if (softwareRepository.existsById(id)) {
            software.setId(id);
            return softwareRepository.save(software);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        softwareRepository.deleteById(id);
    }
}