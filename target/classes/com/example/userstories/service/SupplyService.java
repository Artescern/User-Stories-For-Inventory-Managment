package com.example.userstories.service;

import com.example.userstories.entity.Supply;
import java.util.List;

public interface SupplyService {
    Supply create(Supply supply);
    Supply getById(Integer id);
    List<Supply> getAll();
    Supply update(Integer id, Supply supplyDetail);
    void delete(Integer id);
}
