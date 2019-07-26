package com.entity.allocation.impl;

import com.entity.Room;
import com.entity.allocation.Strategy;

import java.util.List;

public class TopDownStrategy extends Strategy{
    @Override
    public Room getAvailableRoom(List<Room> rooms) {
        return null;
    }
}
