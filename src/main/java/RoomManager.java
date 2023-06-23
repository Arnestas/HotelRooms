import dao.Guest;
import dao.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    /**
     * Creates(initializes) list of rooms.
     * @param numberOfRooms The number of rooms to create.
     * @return The list of created rooms.
     */
    public List<Room> createRooms(int numberOfRooms){
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++){
            int roomNumber = i+1;
            rooms.add(new Room("Room " + roomNumber, true, null, null));
        }
        return rooms;
    }

    /**
     * Checks if there is at least one room that is currently vacant.
     * @param rooms List of rooms to check.
     * @return True if there is at least one vacant room, false otherwise.
     */
    public boolean roomIsVacant(List<Room> rooms){
        for (Room room : rooms){
            if (room.isVacant()){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is at least one room that is currently occupied.
     * @param rooms List of rooms to check.
     * @return True if there is at least one occupied room, false otherwise.
     */
    public boolean roomIsOccupied(List<Room> rooms){
        for (Room room : rooms){
            if (!room.isVacant()){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if specific room had guests before.
     * @param guests List of all guests.
     * @param roomNumber The number of the room to check.
     * @return True if the room had guests before, false otherwise.
     */
    public boolean roomHadGuests(List<Guest> guests, int roomNumber){
        for(Guest guest : guests){
            if(guest.getRoomNumber() == roomNumber){
                return true;
            }
        }
        return false;
    }

    /**
     * Asks to enter room number to execute the action.
     * @param numberOfRooms The number of existing rooms.
     * @return The entered room number.
     */
    public int enterRoomNumber(int numberOfRooms){
        Input input = new Input();
        boolean roomNumberValid = false;
        int roomNumber = Integer.MAX_VALUE;
        while(!roomNumberValid){
            System.out.println("Enter the room number:");
            roomNumber = input.inputInt();
            roomNumberValid = roomNumberIsValid(numberOfRooms, roomNumber);
            if (!roomNumberValid)
                System.out.println("Room number is not valid!");
        }
        return roomNumber;
    }

    /**
     * Checks if room number exists.
     * @param numberOfRooms A number of hotel rooms.
     * @param roomNumber A number of the room we want to check.
     * @return True if the room exists, false otherwise.
     */
    public boolean roomNumberIsValid(int numberOfRooms, int roomNumber){
        return ((roomNumber > 0) && roomNumber <= numberOfRooms);
    }

}
