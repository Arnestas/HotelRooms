import java.util.Locale;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

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

    public String inputString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public boolean loadFromFile(){
        String message = "\nDo you want to load rooms and guests from files? (y / n)";
        return inputString(message).toLowerCase(Locale.ROOT).equals("y");
    }

}
