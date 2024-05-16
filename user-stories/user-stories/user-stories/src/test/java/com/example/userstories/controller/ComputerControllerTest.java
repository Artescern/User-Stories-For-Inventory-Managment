package com.example.userstories.controller;

import com.example.userstories.entity.Computer;
import com.example.userstories.service.ComputerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComputerControllerTest {

    @Mock
    private ComputerService computerService;

    @InjectMocks
    private ComputerController computerController;

    @Test
    public void testGetAllComputers() {
        List<Computer> computers = Arrays.asList(new Computer(), new Computer());
        when(computerService.getAll()).thenReturn(computers);

        ResponseEntity<List<Computer>> responseEntity = computerController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(computers, responseEntity.getBody());
    }

    @Test
    public void testGetComputerById() {
        int computerId = 1;
        Computer computer = new Computer();
        when(computerService.getById(computerId)).thenReturn(computer);

        ResponseEntity<Computer> responseEntity = computerController.getById(computerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(computer, responseEntity.getBody());
    }

    @Test
    public void testCreateComputer() {
        Computer computerToCreate = new Computer();
        when(computerService.create(any(Computer.class))).thenReturn(computerToCreate);

        ResponseEntity<Computer> responseEntity = computerController.create(computerToCreate);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(computerToCreate, responseEntity.getBody());
    }

    @Test
    public void testUpdateComputer() {
        int computerId = 1;
        Computer existingComputer = new Computer();
        Computer updatedComputer = new Computer();
        when(computerService.update(eq(computerId), any(Computer.class))).thenReturn(updatedComputer);

        ResponseEntity<Computer> responseEntity = computerController.update(computerId, updatedComputer);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(updatedComputer, responseEntity.getBody());
    }

    @Test
    public void testDeleteComputer() {
        int computerId = 1;
        ResponseEntity responseEntity = computerController.delete(computerId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(computerService, times(1)).delete(computerId);
    }
}


