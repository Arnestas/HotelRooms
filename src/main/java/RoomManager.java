import dao.Guest;
import dao.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    public List<Room> createRooms(int numberOfRooms){
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++){
            int roomNumber = i+1;
            rooms.add(new Room("Room " + roomNumber, true, null, null));
        }
        return rooms;
    }

    public boolean roomIsVacant(List<Room> rooms){
        for (Room room : rooms){
            if (room.isVacant()){
                return true;
            }
        }
        return false;
    }

    public boolean roomIsOccupied(List<Room> rooms){
        for (Room room : rooms){
            if (!room.isVacant()){
                return true;
            }
        }
        return false;
    }

    public boolean roomHadGuests(List<Guest> guests, int roomNumber){
        for(Guest guest : guests){
            if(guest.getRoomNumber() == roomNumber){
                return true;
            }
        }
        return false;
    }

}
