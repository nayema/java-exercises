package com.nayema.exercise_14;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<VehicleEntry> vehicleEntries = new ArrayList<>();
        vehicleEntries.add(new VehicleEntry("Foo", new Car()));
        vehicleEntries.add(new VehicleEntry("Bar", new Truck()));
        vehicleEntries.add(new VehicleEntry("Bazz", new Bike()));
        vehicleEntries.add(new VehicleEntry("Alpha", new Tricycle()));

        for (int i = 0; i < vehicleEntries.size(); i++) {
            VehicleEntry vehicleEntry = vehicleEntries.get(i);
            String vehicleName = vehicleEntry.vehicleName;
            int numberOfWheels = vehicleEntry.vehicle.getNumberOfWheels();
            System.out.println(vehicleName + " has " + numberOfWheels + " wheels.");
        }
    }
}
