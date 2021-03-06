package com.poker.holdem.server.deserialization.getlobbies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RespRooms {
    @SerializedName("rooms")
    @Expose
    private List<RespRoom> rooms = new ArrayList<>();

    public void addRoom(RespRoom respRoom){
        this.rooms.add(respRoom);
    }

    public List<RespRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<RespRoom> rooms) {
        this.rooms = rooms;
    }
}
