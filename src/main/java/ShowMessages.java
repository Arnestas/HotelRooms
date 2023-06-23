import dao.Guest;

import java.util.List;

public class ShowMessages {

    /**
     * Prints welcome message and describes the program.
     */
    public void showWelcomeMessage() {
        System.out.println("\nWelcome!");
        System.out.println("This program helps to register guests in a hotel!");
        System.out.println("The hotel has 5 single rooms. The rooms are numbered from 1 to 5.");
        System.out.println("No more than one guest lives in one hotel room.");
    }

    /**
     * Prints bye message.
     */
    public void showByeMessage() {
        System.out.println("\nBye! We hope to see you again in the near future.");
    }

    /**
     * Prints a menu - possible actions.
     */
    public void showActions(){
        System.out.println("\nSelect the action by entering the number:");
        System.out.println("1 - Guest registration,");
        System.out.println("2 - Check-out the guest,");
        System.out.println("3 - Room occupancy review,");
        System.out.println("4 - History and status of the room,");
        System.out.println("0 - Exit the program and save data to files.");
    }

    /**
     * Prints the list of previous guests in a specific room.
     * @param guests The list of guests to be searched.
     * @param roomNumber The room number for which the previous guests are displayed.
     */
    public void showGuests(List<Guest> guests, int roomNumber){
        System.out.printf("Previous guests in Room %s:\n", roomNumber);
        for(Guest guest : guests){
            if(guest.getRoomNumber()==roomNumber){
                System.out.println(guest.getGuestName() + " " + guest.getGuestSurname());
            }
        }
    }

}
