import dao.Guest;
import dao.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelRooms {
    public static void main(String[] args) {

        final int NUMBER_OF_ROOMS = 5;
        List<Room> rooms;
        List<Guest> guests;

        ShowMessages showMessages = new ShowMessages();
        RoomManager roomManager = new RoomManager();
        Input input = new Input();
        WriteReadFile writeReadFile = new WriteReadFile();

        showMessages.showWelcomeMessage();

        // TODO try to move this if to another method. ??
        if(input.loadFromFile()){
            guests = writeReadFile.readGuestsHistory();
            rooms = writeReadFile.readRoomOccupancy();
        } else{
            guests = new ArrayList<>();
            rooms = roomManager.createRooms(NUMBER_OF_ROOMS);
        }

        Actions actions = new Actions(rooms, guests);

        int actionNumber = -1;
        while(actionNumber != 0){
            showMessages.showActions();
            actionNumber = input.inputInt();

            switch (actionNumber){
                case 1:
                    if(actions.roomIsVacant()){
                        actions.registration();
                    } else System.out.println("Sorry, we do not have vacant rooms at the moment :( ");
                    break;

                case 2:
                    actions.checkOut();
                    break;

                case 3:
                    actions.roomOccupancyReview();
                    break;

                case 4:
                    actions.roomHistoryReview();
                    break;

                case 0:
                    writeReadFile.saveHistory(guests);
                    writeReadFile.saveOccupancy(rooms);
                    showMessages.showByeMessage();
                    break;
                default:
                    System.out.println("Unexpected value.");
            }
        }
    }
}
