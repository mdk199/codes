package com.runner;

import com.entity.Hotel;
import com.entity.Person;
import com.entity.Room;
import com.service.HotelService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Room> roomList = Arrays.asList(new Room(1, 1)
                , new Room(2, 1)
                , new Room(1, 2)
                , new Room(2, 2)
                , new Room(1, 3)
                , new Room(2, 3));

        Hotel hotel = new Hotel("HOTEL", roomList);
        HotelService hs = new HotelService(hotel);
        try {
            hs.checkIn(new Person("M", 18));
            hs.checkIn(new Person("N", 30));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
