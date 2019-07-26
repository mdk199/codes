package com.entity.allocation;

import com.entity.Room;

import java.util.List;

public abstract class Strategy {

    public abstract Room getAvailableRoom(List<Room> rooms);
}
