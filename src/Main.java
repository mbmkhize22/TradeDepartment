import database_configs.PoliceDatabaseDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import trade_department.Person;
import trade_department.Police;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice = 0;
        while (choice != 6) {
            System.out.println("***Welcome to Department of Trade and Commerce***");
            System.out.println("What do you want to do?");
            System.out.println("1. Police Database");
            System.out.println("2. trade_department.Doctor Database");
            System.out.println("3. trade_department.Driver Database");
            System.out.println("4. trade_department.Teacher Database");
            System.out.println("5. trade_department.Student Database");
            System.out.println("6. Exit");


            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1 -> {
                        PoliceDatabaseDriver policeDatabase = new PoliceDatabaseDriver();
                        int policeChoice = 0;
                        while (policeChoice != 5) {
                            System.out.println("***Police Database Menu***");
                            System.out.println("1. Add Police");
                            System.out.println("2. View Police");
                            System.out.println("3. Update Police");
                            System.out.println("4. Delete Police");
                            System.out.println("5. Back to Main Menu");

                            try {
                                policeChoice = input.nextInt();
                                switch (policeChoice) {
                                    case 1 -> {
                                        System.out.println("Enter Police Name:");
                                        String name = input.next();
                                        System.out.println("Enter Police Age:");
                                        int age = input.nextInt();
                                        System.out.println("Enter Police Rank:");
                                        String rank = input.next();
                                        System.out.println("Enter Police Badge Number:");
                                        String badgeNumber = input.next();
                                        Police police = new Police(name, age, badgeNumber);
                                        policeDatabase.addPolice(police);
                                        System.out.println("Police added successfully!");
                                    }
                                    case 2 -> {
                                        List<Police> policeList = policeDatabase.getAllPolice();
                                        if (policeList.isEmpty()) {
                                            System.out.println("No police records found.");
                                        } else {
                                            for (Police p : policeList) {
                                                System.out.println(p.toString());
                                            }
                                        }
                                    }
                                    case 3 -> System.out.println("Police Update functionality not implemented yet.");
                                    case 4 -> System.out.println("Police Delete functionality not implemented yet.");
                                    case 5 -> System.out.println("Returning to main menu.");
                                    default -> System.out.println("Invalid choice. Please select a number between 1 and 5.");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                                input.next(); // Clear the invalid input
                            }
                        }
                    }
                    case 2 -> System.out.println("trade_department.Doctor Database functionality not implemented yet.");
                    case 3 -> System.out.println("trade_department.Driver Database functionality not implemented yet.");
                    case 4 -> System.out.println("trade_department.Teacher Database functionality not implemented yet.");
                    case 5 -> System.out.println("trade_department.Student Database functionality not implemented yet.");
                    case 6 -> System.out.println("Exiting the program. thank you for using our application");
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 6.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                input.next(); // Clear the invalid input
                continue;
            }
        }

    }
}