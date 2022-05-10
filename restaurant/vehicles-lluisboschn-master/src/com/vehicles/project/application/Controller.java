package com.vehicles.project.application;

import com.vehicles.project.domain.*;
import com.vehicles.project.persistence.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public String createVehicle(int type, String brand, String plate, String color) throws Exception {
        Vehicle vehicle = new VehicleFactory().createVehicle(type, brand, plate, color);
        new VehicleRepository().addVehicle(vehicle);
        return vehicle.getPlate();
    }

    public void addWheels(String plate, String brandWheel, double diameterWheel) throws Exception {
        Vehicle vehicle = new VehicleRepository().findVehicleByPlate(plate);

        List<Wheel> frontWheels = createWheels(vehicle.getNumFrontWheels(), brandWheel, diameterWheel);
        List<Wheel> backWheels = createWheels(vehicle.getNumBackWheels(), brandWheel, diameterWheel);
        vehicle.addWheels(frontWheels, backWheels);
    }

    public List<Wheel> createWheels(int numOfWheels, String brandWheel, double diameterWheel) throws Exception {
        List<Wheel> backWheels = new ArrayList<Wheel>();

        for (int i = 0; i < numOfWheels; i++) {
            backWheels.add(new Wheel(brandWheel, diameterWheel));
        }
        return backWheels;
    }


    public void paintVehicle(String plate, String color) {
        Vehicle vehicle = new VehicleRepository().findVehicleByPlate(plate);
        vehicle.setColor(color);
    }


}