package dao;

public class Room {
    private String roomNumber;
    private boolean vacant;
    private String guestName;
    private String guestSurname;

    public Room() {
    }

    public Room(String roomNumber, boolean vacant, String guestName, String guestSurname) {
        this.roomNumber = roomNumber;
        this.vacant = vacant;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname = guestSurname;
    }

    @Override
    public String toString() {
        return roomNumber + " is occupied by " + guestName + " " + guestSurname;
    }

}
