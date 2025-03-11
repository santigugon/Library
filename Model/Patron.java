package Model;
import java.util.ArrayList;

public class Patron {
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
        if (borrowedBooks.contains(book)) {
            System.out.println("Book already borrowed.");
            return;
        }
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            System.out.println("Book not borrowed.");
            return;
        }
        borrowedBooks.remove(book);
        System.out.println("Book returned successfully.");
    }
}
