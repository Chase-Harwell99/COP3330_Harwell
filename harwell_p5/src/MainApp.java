import java.util.Scanner;

public class MainApp {

    private static final Scanner selection = new Scanner(System.in);

    public static void main(String[] args) {
        boolean menu = true;
        while(menu) {
            switch (MainMenu()) {
                case 1 -> {
                    TaskApp.main(null);
                }
                case 2 -> {
                    ContactApp.main(null);
                }
                case 3 -> {
                    menu = false;
                }
                default -> {
                    System.out.println("You entered an invalid choice. Please enter a valid choice.");
                    menu = true;
                }
            }
        }
    }

    private static int MainMenu() {
        System.out.println("       Select Your Application         ");
        System.out.println("---------------------------------------\n");
        System.out.println("1) Task list");
        System.out.println("2) Contact list");
        System.out.println("3) Exit the program");

        return selection.nextInt();

    }
}
