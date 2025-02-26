package Model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void displayBook(){
        if (books.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        System.out.println("Lista de libros:");
        for (Book book : books) {
            book.display();
        }
    }

    public void displayPatron(){
        if (patrons.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        System.out.println("Lista de libros:");
        for (Patron patron : patrons) {
            patron.displayPatron();
        }
    }

    public void addBook(String title, String author, int numberOfCopies, String isbn) {
        books.add(new Book(title, author, numberOfCopies, isbn));
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.isbn.equals(ISBN));
    }

    public void addPatron(String name, int id, String details) {
        patrons.add(new Patron(name, id, details ));
    }

    public void searchBook(String query){
        for (Book book : books){
            if(book.title.isEmpty()){
                
            }
        }
    }
}