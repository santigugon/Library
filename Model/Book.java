package Model;
public class Book {
    private String title;
    private String author;
    private int numberOfCopies;
    private String isbn;

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

    public boolean borrowBook() {
        if (numberOfCopies > 0) {
            numberOfCopies--;
            return true;
        } else {
            return false;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }


    public void returnBook() {
        numberOfCopies++;
    }

}
