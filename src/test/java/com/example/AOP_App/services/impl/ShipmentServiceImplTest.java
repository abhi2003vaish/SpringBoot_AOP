package com.example.AOP_App.services.impl;

import com.example.AOP_App.services.Impl.ShipmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Test
    void aopTestOrderPackage() {
        shipmentService.orderPackage(4L);
    }

    @Test
    void aopTestTrackPackage() {

        shipmentService.trackPackage(4L);
    }
}
