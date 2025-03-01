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

    public void displayAllBooks(){
        if (books.isEmpty()) {
            System.out.println("There are no books in the library.");
            return;
        }
        System.out.println("List of books:");
        for (int i = 0; i < books.size(); i++){
            System.out.println("----------------------------");
            System.out.println(i + 1 + ".");
            books.get(i).display();
        }
    }

    public void displayPatron(){
        if (patrons.isEmpty()) {
            System.out.println("There are no patrons in the library.");
            return;
        }
        System.out.println("List of patrons:");
        for (int i = 0; i < patrons.size(); i++){
            System.out.println("----------------------------");
            System.out.println(i + 1 + ".");
            patrons.get(i).displayPatron();
        }
    }

    public void addBook(String title, String author, int numberOfCopies, String isbn) {
        books.add(new Book(title, author, numberOfCopies, isbn));
        System.out.println("Book added successfully.");
    }

    public void removeBook(String ISBN) {
        boolean wasDeleted = books.removeIf(book -> book.isbn.equals(ISBN));
        if (wasDeleted) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void addPatron(String name, int id, String details) {
        patrons.add(new Patron(name, id, details ));
        System.out.println("Patron added successfully.");
    }

    // 1 for title, 2 for author, 3 for isbn
    public Book searchBook(int type, String query){
        Book emptyBook = new Book("No books found","No books found",4,"No books found");
        for (Book book : books){
            if(type == 1){
                if(book.title.isEmpty()){
                    return emptyBook;
                }
                else if(book.title.equals(query)){
                    return book;
                }
            }
            else if(type == 2){

                if(book.author.isEmpty()){
                    return emptyBook;
                }
                else if(book.author.equals(query)){
                    return book;
                }
            }
            else if(type == 3){
                if(book.isbn.isEmpty()){
                    return emptyBook;
                }
                else if(book.isbn.equals(query)){
                    return book;
                }
            }
        }
        return emptyBook;
    }

    public Patron searchPatron(int id){
        Patron emptyPatron = new Patron("No patrons found",0,"No patrons found");
        for (Patron patron : patrons){
            if(patron.id == id){
                return patron;
            }
        }
        return emptyPatron;
    }

    public void borrowBook(int patronId, String isbn) {
        Patron patron = searchPatron(patronId);
        Book book = searchBook(3, isbn);
        if (patron.name.equals("No patrons found")) {
            System.out.println("Patron not found.");
        } else if (book.title.equals("No books found")) {
            System.out.println("Book not found.");
        } else {
            if (book.borrowBook()) {
                patron.borrowBook(book);
            } else {
                System.out.println("Book not available. No more copies left");
            }
        }
    }

    public void returnBook(int patronId, String isbn) {
        Patron patron = searchPatron(patronId);
        Book book = searchBook(3, isbn);
        if (patron.name.equals("No patrons found")) {
            System.out.println("Patron not found.");
        } else if (book.title.equals("No books found")) {
            System.out.println("Book not found.");
        } else {
            patron.returnBook(book);
            book.returnBook();
        }
    }
}