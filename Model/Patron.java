package Model;
import java.util.ArrayList;
import java.util.Random;

public class Patron implements Runnable {
    public String name;
    public int id;
    public String details; 
    public ArrayList<Book> borrowedBooks;
    private Library library;
    private Random random = new Random();

    public Patron (String name, int id, String details){
        this.name = name;
        this.id = id;
        this.details = details;
        this.borrowedBooks = new ArrayList<>();
    }

    public void displayPatron() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Contact details: " + details);
        System.out.println("----------------------------");
    }

    public void borrowBook(Book book) {
        try {
            int randomDelay = (int) (Math.random() * 2000) + 1;
            Thread.sleep(randomDelay); 
            System.out.println(this.name + " has read for " + randomDelay + " milliseconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        }

        if (borrowedBooks.contains(book)) {
            System.out.println("Book already borrowed.");
            book.returnBook();
            return;
        }
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully.");

    }

    public void returnBook(Book book) {
        try {
             int randomDelay = (int) (Math.random() * 2000) + 1;
            Thread.sleep(randomDelay); 
            System.out.println(this.name + " has returned its book in " + randomDelay + " milliseconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        }
        
        if (!borrowedBooks.contains(book)) {
            System.out.println("Book not borrowed.");
            book.borrowBook();
            return;
        }
        borrowedBooks.remove(book);
        System.out.println("Book returned successfully.");


    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
            return;
        }
        System.out.println("Borrowed books "+ numberOfBorrowedBooks()+ " books:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println("----------------------------");
            System.out.println(i + 1 + ".");
            borrowedBooks.get(i).displayNoCopies();
        }
    }

    public int numberOfBorrowedBooks() {
        return borrowedBooks.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public String getName() {
        return name;
    }


    @Override
    public void run() {
        if (library == null) {
            System.out.println("Patron " + name + " has no library to interact with!");
            return;
        }
        
        try {
            // Cada uno de los patrones va a hacer un número aleatorio de acciones entre 1 y 3
            int numberOfActions = random.nextInt(3) + 1;
            
            for (int i = 0; i < numberOfActions; i++) {
                String isbn = "isbn" + random.nextInt(3000);
                
                // Va a tener un 70% de probabilidad de pedir un libro y un 30% de devolverlo
                if (random.nextDouble() < 0.7) {
                    library.borrowBook(this.id, isbn);
                    Thread.sleep(random.nextInt(1000) + 500); 
                } else if (!borrowedBooks.isEmpty()) {
                    Book bookToReturn = borrowedBooks.get(random.nextInt(borrowedBooks.size()));
                    library.returnBook(this.id, bookToReturn.getIsbn());
                    Thread.sleep(random.nextInt(1000) + 500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        } catch (Exception e) {
            System.out.println("Error with patron " + name + ": " + e.getMessage());
        }
    }
}
