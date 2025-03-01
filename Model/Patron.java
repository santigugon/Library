package Model;
import java.util.List;

public class Patron {
    public String name;
    public int id;
    public String details; 
    public List<Book> borrowedBooks;

    public Patron (String name, int id, String details){
        this.name = name;
        this.id = id;
        this.details = details;
    }

    public void displayPatron() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Contact details: " + details);
        System.out.println("----------------------------");
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println("Book returned successfully.");
    }
}
