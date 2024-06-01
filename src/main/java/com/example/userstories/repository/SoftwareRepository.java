package com.example.userstories.repository;

import com.example.userstories.entity.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareRepository extends JpaRepository<Software, Integer> {
}