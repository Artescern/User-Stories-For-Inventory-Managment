package com.example.userstories.service;

import com.example.userstories.entity.Item;

import java.util.List;

public interface ItemService {
    Item create(Item item);
    Item getById(Integer id);
    List<Item> getAll();
    Item update(Integer id, Item itemDetail);
    void delete(Integer id);
}
