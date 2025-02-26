package Model;
public class Book {
    public String title;
    public String author;
    public int numberOfCopies;
    public String isbn;

    public Book(String title, String author, int numberOfCopies, String isbn) {
        this.title = title;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        this.isbn = isbn;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of copies: " + numberOfCopies);
        System.out.println("ISBN: " + isbn);
        System.out.println("----------------------------");
    }



}
