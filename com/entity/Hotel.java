package com.entity;

import com.entity.allocation.Strategy;

import java.util.List;

public class Hotel {

    private Integer id;

    private String name;

    private List<Room> rooms;

    private Strategy strategy;

    public Hotel(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
