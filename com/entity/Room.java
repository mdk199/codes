package com.entity;

import java.util.Objects;

public class Room implements Comparable<Room> {

    private Integer roomNo;

    private Integer floorNo;

    private Status status;

    private Integer hotelId;

    public Room(Integer roomNo, Integer floorNo) {
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.status = Status.AVAILABLE;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(roomNo, room.roomNo) &&
                Objects.equals(floorNo, room.floorNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomNo, floorNo);
    }

    @Override
    public int compareTo(Room o) {
        if (this.floorNo >= o.floorNo) {
            if (this.roomNo >= o.roomNo)
                return 1;
            else
                return -1;
        } else {
            if (this.roomNo >= o.roomNo)
                return 1;
            else
                return -1;
        }
    }
}
