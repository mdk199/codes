package com.service;

import com.entity.Hotel;
import com.entity.Person;
import com.entity.Room;
import com.entity.Status;
import com.entity.allocation.impl.BottomUpStrategy;
import com.entity.allocation.impl.TopDownStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class HotelService {
    Hotel hotel;

    Map<Integer, List<Room>> floorLevelBookedRooms = new ConcurrentHashMap<>();

    Map<Integer, List<Room>> floorLevelAvailableRooms;

    Map<Person, Room> roomPersonMap = new HashMap<>();


    public HotelService(Hotel hotel) {
        this.hotel = hotel;
        floorLevelAvailableRooms = new ConcurrentHashMap<>(hotel.getRooms().stream().collect(Collectors.groupingBy(Room::getFloorNo)));
        this.hotel.setStrategy(new BottomUpStrategy());
        //floorLevel Aroom
    }

    public Room checkIn(Person person) throws Exception {
        Room room = null;
        room = this.hotel.getStrategy().getAvailableRoom(this.hotel.getRooms());
        room.setStatus(Status.BOOKED);
        return room;
//        List<Integer> floors = new ArrayList<>(floorLevelAvailableRooms.keySet());
//        floorNo = Objects.isNull(floorNo) ? floors.get(0) : floorNo;
//        return book(person, floorNo) ;
    }

    private Room book(Person person, Integer floorNo) throws Exception {
        Room room = null;
        List<Room> rooms = floorLevelAvailableRooms.get(floorNo);
        if (rooms == null)
            throw new Exception("Not Available");

        room = rooms.get(0);
        floorLevelAvailableRooms.get(floorNo).remove(room);
        if (floorLevelAvailableRooms.get(floorNo).isEmpty()) {
            floorLevelAvailableRooms.remove(floorNo);
        }
        if(floorLevelBookedRooms.get(room.getFloorNo()) == null)
            floorLevelBookedRooms.put(room.getFloorNo(), new ArrayList<>());

        floorLevelBookedRooms.get(room.getFloorNo()).add(room);

        roomPersonMap.put(person, room);

        return room;
    }

    public void checkOut(Person person) {

    }

    public Room findOccupantRoom(Person person) {
        return null;
    }

    public List<Person> classifyOccupants(int minAge, int maxAge) {
        return null;
    }


}
