package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Library {
    private final ReentrantLock borrowLock = new ReentrantLock();
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
        boolean wasDeleted = books.removeIf(book -> book.getIsbn().equals(ISBN));
        if (wasDeleted) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void addPatron(String name, int id, String details) {
        if(id < 0 ){
            System.out.println("ID cannot be negative.");
            return;
        }
        for(Patron patron : patrons){
            if(patron.id == id){
                throw new IllegalArgumentException("Patron with this ID already exists.");
            }
        }
        patrons.add(new Patron(name, id, details ));
        System.out.println("Patron added successfully.");
    }

    // 1 for title, 2 for author, 3 for isbn
    public Book searchBook(int type, String query){
        for (Book book : books){
            if(type == 1){
                if(book.getTitle().isEmpty()){
                    throw new IllegalArgumentException("Not book found.");
                }
                else if(book.getTitle().equals(query)){
                    return book;
                }
            }
            else if(type == 2){

                if(book.getAuthor().isEmpty()){
                    throw new IllegalArgumentException("Not book found.");
                }
                else if(book.getAuthor().equals(query)){
                    return book;
                }
            }
            else if(type == 3){
                if(book.getIsbn().isEmpty()){
                    throw new IllegalArgumentException("Not book found.");
                }
                else if(book.getIsbn().equals(query)){
                    return book;
                }
            }
        }
        throw new IllegalArgumentException("Not book found.");
    }

    public Patron searchPatron(int id){
        for (Patron patron : patrons){
            if(patron.id == id){
                return patron;
            }
        }
        throw new IllegalArgumentException("No patrons found");
    }

    public synchronized void borrowBook(int patronId, String isbn) {
        Patron patron = searchPatron(patronId);
        Book book = searchBook(3, isbn);
        borrowLock.lock();
        try {
             int randomDelay = (int) (Math.random() * 2000) + 1;
            Thread.sleep(randomDelay); 
            System.out.println( " Has read for " + randomDelay + " milliseconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        }
        finally {
            borrowLock.unlock();
        }

        if (patron.name.equals("No patrons found")) {
            System.out.println("Patron not found.");
        } else if (book.getTitle().equals("No books found")) {
            System.out.println("Book not found.");
        } else {
            if (book.borrowBook()) {
                patron.borrowBook(book);
            } else {
                System.out.println("Book not available. No more copies left");
            }
        }
    }

    public synchronized void returnBook(int patronId, String isbn) {
        try {
            int randomDelay = (int) (Math.random() * 2000) + 1;
            Thread.sleep(randomDelay); 
            System.out.println("as returned its book in " + randomDelay + " milliseconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " was interrupted.");
        }

        Patron patron = searchPatron(patronId);
        Book book = searchBook(3, isbn);
        if (patron.name.equals("No patrons found")) {
            System.out.println("Patron not found.");
        } else if (book.getTitle().equals("No books found")) {
            System.out.println("Book not found.");
        } else {
            patron.returnBook(book);
            book.returnBook();
        }
    }

    public boolean isbnAlreadyExists(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                return true;
            }
        }
        return false;
    }

    public void editBook(String isbn, String title, String author, int numberOfCopies){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                book.setTitle(title) ;
                book.setAuthor(author);
                book.setNumberOfCopies(numberOfCopies);;
                System.out.println("Book edited successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void editPatron(int id, String name, String details){
        Patron patronToEdit =searchPatron(id);
        patronToEdit.setName(name);
        patronToEdit.setDetails(details);
        System.out.println("Patron edited successfully.");
    }
}