import dao.Guest;
import dao.Room;

import java.util.List;

public class Actions {
    Input input = new Input();
    ShowMessages showMessages = new ShowMessages();
    RoomManager roomManager = new RoomManager();
    private List<Guest> guests;
    private List<Room> rooms;

    /**
     * Constructs an instance of the Actions class with the provided lists of rooms and guests.
     * @param rooms The list of rooms in the hotel.
     * @param guests The list of guests who where staying in the hotel.
     */
    public Actions(List<Room> rooms, List<Guest> guests){
        this.rooms = rooms;
        this.guests = guests;
    }

    /**
     * Checks if there is at least one room that is currently vacant.
     * @return True if there is at least one vacant room, false otherwise.
     */
    public boolean roomIsVacant(){
        return roomManager.roomIsVacant(rooms);
    }

    /**
     * Checks if there is at least one occupied room.
     * @return True if there is at least one occupied room, false otherwise.
     */
    public boolean roomIsOccupied(){
        return roomManager.roomIsOccupied(rooms);
    }

    /**
     * Checks if specific room had guests before.
     * @param roomNumber The number of the room to check.
     * @return True if the room had guests before, false otherwise.
     */
    public boolean roomHadGuests(int roomNumber){
        return roomManager.roomHadGuests(guests, roomNumber);
    }

    /**
     * Registers guest to the room, makes the room occupied.
     */
    public void registration(){
        String name = input.inputString("Enter the name of the guest:");
        String surname = input.inputString("Enter the surname:");
        for(Room room : rooms){
            if (room.isVacant()){
                room.setVacant(false);
                room.setGuestName(name);
                room.setGuestSurname(surname);
                System.out.println("The guest was checked in.");
                System.out.println(room);
                break;
            }
        }
    }

    /**
     * Check out's the guest from the room.
     */
    public void checkOut(){
        int roomNumber = roomManager.enterRoomNumber(rooms.size());
        if(rooms.get(roomNumber-1).isVacant()){
            System.out.println("There are no guests in this room. Please, check the room number and try again.");
        } else{
            String name = rooms.get(roomNumber-1).getGuestName();
            String surname = rooms.get(roomNumber-1).getGuestSurname();
            guests.add(new Guest(roomNumber, name, surname));
            Room tempRoom = new Room("Room " + roomNumber, true, null, null);
            rooms.set(roomNumber-1, tempRoom);
            System.out.printf("The guest %s %s was checked out.\n", name, surname);
        }
    }

    /**
     * Prints the list of occupied rooms and their guests.
     */
    public void roomOccupancyReview(){
        if(roomIsOccupied()){
            System.out.println("The list of occupied rooms: ");
            int numberOfVacantRooms = 0;
            for (Room room : rooms){
                if (!room.isVacant()){
                    System.out.println(room);
                } else numberOfVacantRooms ++;
            }
            System.out.printf("We have %s vacant room(s) at the moment.\n", numberOfVacantRooms);
        } else{
            System.out.println("All rooms are vacant at the moment.");
        }
    }

    /**
     * Prints the list of all guests who were stayed in a specific room.
     */
    public void roomHistoryReview(){
        int roomNumber = roomManager.enterRoomNumber(rooms.size());

        if (rooms.get(roomNumber-1).isVacant()){
            System.out.printf("Room %s is vacant.\n", roomNumber);
        } else System.out.println(rooms.get(roomNumber-1));

        if(!roomHadGuests(roomNumber)){
            System.out.printf("No one has visited Room %s before.\n", roomNumber);
        } else {
            showMessages.showGuests(guests, roomNumber);
        }
    }
}
