package com.example.userstories.controller;

import com.example.userstories.entity.Supply;
import com.example.userstories.service.SupplyService;
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
public class SupplyControllerTest {

    @Mock
    private SupplyService supplyService;

    @InjectMocks
    private SupplyController supplyController;

    @Test
    public void testGetAllSupplies() {
        List<Supply> supplies = Arrays.asList(new Supply(), new Supply());
        when(supplyService.getAll()).thenReturn(supplies);

        ResponseEntity<List<Supply>> responseEntity = supplyController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(supplies, responseEntity.getBody());
    }

    @Test
    public void testGetSupplyById() {
        int supplyId = 1;
        Supply supply = new Supply();
        when(supplyService.getById(supplyId)).thenReturn(supply);

        ResponseEntity<Supply> responseEntity = supplyController.getById(supplyId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(supply, responseEntity.getBody());
    }

    @Test
    public void testCreateSupply() {
        Supply supplyToCreate = new Supply();
        when(supplyService.create(any(Supply.class))).thenReturn(supplyToCreate);

        ResponseEntity<Supply> responseEntity = supplyController.create(supplyToCreate);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(supplyToCreate, responseEntity.getBody());
    }

    @Test
    public void testUpdateSupply() {
        int supplyId = 1;
        Supply existingSupply = new Supply();
        Supply updatedSupply = new Supply();
        when(supplyService.update(eq(supplyId), any(Supply.class))).thenReturn(updatedSupply);

        ResponseEntity<Supply> responseEntity = supplyController.update(supplyId, updatedSupply);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(updatedSupply, responseEntity.getBody());
    }

    @Test
    public void testDeleteSupply() {
        int supplyId = 1;
        ResponseEntity responseEntity = supplyController.delete(supplyId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(supplyService, times(1)).delete(supplyId);
    }
}
