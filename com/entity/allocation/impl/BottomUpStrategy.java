package com.entity.allocation.impl;

import com.entity.Room;
import com.entity.Status;
import com.entity.allocation.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BottomUpStrategy extends Strategy {
    @Override
    public Room getAvailableRoom(List<Room> rooms) {
        Map<Integer, List<Room>> floorLevelAvailableRooms = new ConcurrentHashMap<>(rooms.stream().collect(Collectors.groupingBy(Room::getFloorNo)));
        Integer floorNo = new ArrayList<>(floorLevelAvailableRooms.keySet()).get(0);
        List<Room> roomsAtFloor = floorLevelAvailableRooms.get(floorNo).stream().filter(r -> r.getStatus() != Status.BOOKED).collect(Collectors.toList());
        return roomsAtFloor.get(0);
    }
}
