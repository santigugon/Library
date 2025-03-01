import java.util.Scanner;
import Model.Library;
import Model.Patron;

public class LibraryManagementSystem {
    public static void main (String[] args) {
        Library library = new Library();
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
                                System.out.print("Enter the title of the book: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter the author of the book: ");
                                String author = scanner.nextLine();
                                System.out.print("Enter the number of copies: ");
                                int numberOfCopies = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter the ISBN of the book: ");
                                String isbn = scanner.nextLine();
                                library.addBook(title, author, numberOfCopies, isbn);
                                break;
                            
                            case 2: // display all books function
                                library.displayAllBooks();
                                break;

                            case 3: // remove book function
                                System.out.print("Enter the ISBN of the book you want to remove: ");
                                String isbnToRemove = scanner.nextLine();
                                library.removeBook(isbnToRemove);
                                break;

                            case 4: // register patrons function
                                System.out.print("Enter the name of the patron: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter the ID of the patron: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter the details of the patron: ");
                                String details = scanner.nextLine();
                                library.addPatron(name, id, details);
                                break;

                            case 5: // view patrons function
                                library.displayPatron();
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
                                library.displayAllBooks();
                                break;

                            case 2: // search book function
                                System.out.println("Type the number of the search type:");
                                System.out.println("1. Title");
                                System.out.println("2. Author");
                                System.out.println("3. ISBN");
                                int userChoiceSearch = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter the query of the book you want to search: ");
                                String query = scanner.nextLine();
                                if(userChoiceSearch>0 && userChoiceSearch<4)
                                    library.searchBook(userChoiceSearch, query).display();
                                else{
                                    System.out.println("Invalid option. Please try again.");
                                }
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
                    isUserType = true;
                    while (isUserType) {
                        boolean isUserLogged = false;
                        System.out.println("Patron System");
                        System.out.println("Enter your patron id: ");
                        int patronId = scanner.nextInt();
                        scanner.nextLine();
                        Patron currPatron = library.searchPatron(patronId);
                        if(currPatron.name.equals("No patrons found")){
                            System.out.println("Patron not found.");
                            break;
                        }else{
                            isUserLogged = true;
                        }
                        while (isUserLogged) {
                            
                            System.out.println("1. Display All Books");
                            System.out.println("2. Borrow Books");
                            System.out.println("3. Return Books");
                            System.out.println("4. Go back");
                            System.out.print("Choose an option: ");
                            int patronChoice = scanner.nextInt();
                            scanner.nextLine();
                            switch(patronChoice){
                                case 1: // display all books function
                                library.displayAllBooks();
                                break;
                                
                            }
                        }

                    }
                case 4:
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