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
            book.returnBook();
            return;
        }
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(Book book) {
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
