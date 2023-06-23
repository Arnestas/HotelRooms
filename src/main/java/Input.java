import java.util.Locale;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    /**
     * Method to input integers. Checks if the input is valid.
     * @return Entered number.
     */
    public int inputInt(){
        try{
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;
        } catch (Exception e){
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
            return Integer.MAX_VALUE;
        }
    }

    /**
     * Method to inpud string value.
     * @param message Message or question to show to user.
     * @return Entered value.
     */
    public String inputString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Shows the question about reading or not from file.
     * @return True if user decides to read data from file, false otherwise.
     */
    public boolean loadFromFile(){
        String message = "\nDo you want to load rooms and guests from files? (y / n)";
        return inputString(message).toLowerCase(Locale.ROOT).equals("y");
    }

}
