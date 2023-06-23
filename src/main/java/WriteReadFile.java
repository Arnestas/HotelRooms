import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.Guest;
import dao.Room;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WriteReadFile {
    private static final Logger LOGGER = Logger.getLogger(WriteReadFile.class.getName());
    final String HISTORY_FILE_ADDRESS = "src/main/resources/history.json";
    final String ROOM_OCCUPANCY_FILE_ADDRESS = "src/main/resources/room_occupancy.json";

    /**
     * Saves a list of guests who were visited the hotel.
     * @param data A list of guests to save to file.
     */
    public void saveHistory(List<Guest> data){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LOGGER.info("This is an informational message");
        try(FileWriter writer = new FileWriter(HISTORY_FILE_ADDRESS)) {
            gson.toJson(data, writer);
            LOGGER.info("Guests data has been saved to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves a list of all rooms and current guests on them.
     * @param data A list of rooms to save to file.
     */
    public void saveOccupancy(List<Room> data){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(ROOM_OCCUPANCY_FILE_ADDRESS)) {
            gson.toJson(data, writer);
            LOGGER.info("Rooms data has been saved to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads/loads data of guests from a file.
     * @return A list of visitors.
     */
    public List<Guest> readGuestsHistory(){
        Gson gson = new Gson();
        try(Reader data = new FileReader(HISTORY_FILE_ADDRESS)){
            Type listType = new TypeToken<ArrayList<Guest>>(){}.getType();
            List<Guest> guests = gson.fromJson(data, listType);
            LOGGER.info("Guests data has been loaded from a file.");
            return guests;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads/loads data of rooms from a file.
     * @return A list of rooms.
     */
    public List<Room> readRoomOccupancy(){
        Gson gson = new Gson();
        try(Reader data = new FileReader(ROOM_OCCUPANCY_FILE_ADDRESS)){
            Type listType = new TypeToken<ArrayList<Room>>(){}.getType();
            List<Room> rooms = gson.fromJson(data, listType);
            LOGGER.info("Rooms data has been loaded from a file.");
            return rooms;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}