package com.example.AOP_App.services;

public interface ShipmentService {

    String orderPackage(Long orderId);

    String trackPackage(Long orderId);
}
