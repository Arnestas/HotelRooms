import dao.Guest;
import dao.Room;

import java.util.List;

public class Actions {
    Input input = new Input();
    ShowMessages showMessages = new ShowMessages();
    RoomManager roomManager = new RoomManager();
    private List<Guest> guests;
    private List<Room> rooms;

    public Actions(List<Room> rooms, List<Guest> guests){
        this.rooms = rooms;
        this.guests = guests;
    }

    public boolean roomIsVacant(){
        return roomManager.roomIsVacant(rooms);
    }

    public boolean roomIsOccupied(){
        return roomManager.roomIsOccupied(rooms);
    }

    public boolean roomHadGuests(int roomNumber){
        return roomManager.roomHadGuests(guests, roomNumber);
    }

    // 1 - Guest registration,
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

    // 2 - Check-out the guest
    public void checkOut(){
        showMessages.enterRoomNumber();
        int roomNumber = input.inputInt();
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

    // 3 - Room occupancy review
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

    // 4 - History and status of the room.
    public void roomHistoryReview(){
        showMessages.enterRoomNumber();
        int roomNumber = input.inputInt();

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
