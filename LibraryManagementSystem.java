package Library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        boolean isUserType = true;

        while (isRunning) {
            System.out.println("Library Management System");
            System.out.println("1. Librarian");  
            System.out.println("2. User");
            System.out.println("3. Exit");  
            System.out.print("Choose an option: ");  
            int choiceUserType = scanner.nextInt();
            scanner.nextLine();

            switch (choiceUserType) {
                case 1:
                    while (isUserType) {
                        System.out.println("Librarian System");
                        System.out.println("1. Add Book");
                        System.out.println("2. Display All Books");
                        System.out.println("3. Remove Book");
                        System.out.println("4. Register Patron");
                        System.out.println("5. View Patrons");
                        System.out.println("6. Go back");
                        System.out.print("Choose an option: ");  
                        int librarianChoice = scanner.nextInt();
                        scanner.nextLine();
                    }
                    break;
                
                case 2:
                    while (isUserType) {
                        System.out.println("User System");
                        System.out.println("1. Display All Books");
                        System.out.println("2. Search Book");
                        System.out.println("6. Go back");
                        System.out.print("Choose an option: ");  
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();
                    }
                    break;
                
                case 3:
                    isRunning = false;
                    break;
                
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thanks for using this program!");
    }
}