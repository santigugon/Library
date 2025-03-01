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
    public String searchBook(int type, String query){
        for (Book book : books){
            System.out.println("Book title: "+book.title);
            if(type == 1){
                System.out.println(book.title + "== " + query);
                System.out.println(book.title==query);
                if(book.title.isEmpty()){
                    return "No books found 1";
                }
                else if(book.title.equals(query)){
                    return "Book found "+book.title;
                }
            }
            else if(type == 2){

                if(book.author.isEmpty()){
                    return "No books found 2";
                }
                else if(book.author.equals(query)){
                    return "Book found "+book.title;
                }
            }
            else if(type == 3){
                if(book.isbn.isEmpty()){
                    return "No books found 3";
                }
                else if(book.isbn.equals(query)){
                    return "Book found "+book.title;
                }
            }
        }
        return "No books found 4";
    }
}