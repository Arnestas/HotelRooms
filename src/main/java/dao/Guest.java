package dao;

public class Guest {
    private int roomNumber;
    private String guestName;
    private String guestSurname;

    public Guest() {
    }

    public Guest(int roomNumber, String guestName, String guestSurname) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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
        return roomNumber + " " + guestName + " " + guestSurname;
    }

}
