package com.example.userstories.service;

import com.example.userstories.entity.Supply;
import com.example.userstories.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @Override
    public List<Supply> getAll() {
        return supplyRepository.findAll();
    }

    @Override
    public Supply getById(Integer id) {
        Optional<Supply> optionalSupply = supplyRepository.findById(id);
        return optionalSupply.orElse(null);
    }

    @Override
    public Supply create(Supply supply) {
        return supplyRepository.save(supply);
    }

    @Override
    public Supply update(Integer id, Supply supply) {
        if (supplyRepository.existsById(id)) {
            supply.setId(id);
            return supplyRepository.save(supply);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        supplyRepository.deleteById(id);
    }
}
