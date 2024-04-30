package com.example.userstories.service;

import com.example.userstories.entity.Item;
import com.example.userstories.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getById(Integer id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.orElse(null);
    }

    @Override
    public Item create(Item item) {
        // Additional logic can be added here if needed
        return itemRepository.save(item);
    }

    @Override
    public Item update(Integer id, Item item) {
        if (itemRepository.existsById(id)) {
            item.setId(id);
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        itemRepository.deleteById(id);
    }
}
