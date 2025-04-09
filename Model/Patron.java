package Model;
import java.util.ArrayList;

public class Patron implements Runnable {
    public String name;
    public int id;
    public String details; 
    public ArrayList<Book> borrowedBooks;

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
            const int randomDelay = (int) (Math.random() * 2000) + 1;
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
            const int randomDelay = (int) (Math.random() * 2000) + 1;
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
}
