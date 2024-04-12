package com.example.userstories.controller;

import com.example.userstories.entity.Item;
import com.example.userstories.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        List<Item> items = itemService.getAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        item = itemService.create(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Integer id) {
        Item item = itemService.getById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> update(@PathVariable("id") Integer id, @RequestBody Item itemDetail){
        itemDetail = itemService.update(id, itemDetail);
        return new ResponseEntity<>(itemDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        itemService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
