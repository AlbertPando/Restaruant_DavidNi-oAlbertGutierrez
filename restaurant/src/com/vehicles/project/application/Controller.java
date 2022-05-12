package com.vehicles.project.application;

import com.vehicles.project.domain.Restaurant;
import com.vehicles.project.persistence.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public int createRestaurant(String name){
        Restaurant restaurant = new Restaurant(name);
        new RestaurantRepository().addRestaurant(restaurant);
        return restaurant.getId();
    }

    public void addPeopleInRestaurant(int id, int numPeople) throws Exception {
        Restaurant restaurant = new RestaurantRepository().findRestaurantById(id);
        restaurant.addPeopleInRestaurant(numPeople);
    }
}
