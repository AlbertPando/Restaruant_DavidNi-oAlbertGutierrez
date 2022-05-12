package com.vehicles.project.view;


import Keyboard.Keyboard;
import com.vehicles.project.application.Controller;
import com.vehicles.project.utilities.ConstantsUtilities;


public class Main {

    public static void main(String[] args) throws Exception {
            int restaurantId = createRestaurant();
            addPeople(restaurantId);
    }

    private static int createRestaurant() throws Exception {

        String nameRestaurant = askRestaurantName();
        return new Controller().createRestaurant(nameRestaurant);
    }

    private static void addPeople(int id) throws Exception{
        new Controller().addPeopleInRestaurant(id,askNumPeople());
    }

    private static String askRestaurantName() {
        System.out.println("Name of the restuarant: ");
        return Keyboard.readString();
    }

    public static int askNumPeople() {
        System.out.println("How many people for the reservation? ");
        return Keyboard.readInt();
    }

}