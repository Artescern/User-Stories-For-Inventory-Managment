package com.example.userstories.repository;

import com.example.userstories.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ItemRepository extends JpaRepository<Item, Integer> {

}
