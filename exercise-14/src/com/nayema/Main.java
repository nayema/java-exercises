package com.nayema;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        Vehicle truck1 = new Truck();
        Vehicle truck2 = new Truck();
        Vehicle truck3 = new Truck();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(truck1);
        vehicles.add(truck2);
        vehicles.add(truck3);

        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("A " + vehicles.get(i).getClass().getSimpleName() + " has " + vehicles.get(i).getNumberOfWheels() + " wheels.");
        }
    }
}
