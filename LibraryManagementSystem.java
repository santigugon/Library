package Library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        boolean isUserType = false;

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
                    isUserType = true;
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

                        switch (librarianChoice) {
                            case 1: // addbook function
                                break;
                            
                            case 2: // display all books function
                                break;

                            case 3: // remove book function
                                break;

                            case 4: // register patrons function
                                break;

                            case 5: // view patrons function
                                break;

                            case 6:
                                isUserType = false;
                                break;
                        
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;
                
                case 2:
                    isUserType = true;
                    while (isUserType) {
                        System.out.println("User System");
                        System.out.println("1. Display All Books");
                        System.out.println("2. Search Book");
                        System.out.println("3. Go back");
                        System.out.print("Choose an option: ");  
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (userChoice) {
                            case 1: // display all books function
                                break;

                            case 2: // search book function
                                break;

                            case 3:
                                isUserType = false;
                                break;
                        
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
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