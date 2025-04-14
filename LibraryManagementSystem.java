import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Model.Library;
import Model.Patron;

public class LibraryManagementSystem {
    public static void main (String[] args) {
        Library library = new Library();
        
        for( int i = 0; i < 3000; i++){
            int randomnumberOfCopies = (int) (Math.random() * 20) + 1;
            library.addBook("title"+i, "author"+i, randomnumberOfCopies, "isbn"+i);
        }

        for( int i = 0; i < 30000; i++){
            library.addPatron("nombre"+i, i, "details"+i);
        }

        for(Patron patron : library.patrons) {
            patron.setLibrary(library);
            Thread thread = new Thread(patron);
            thread.start();
        }
    }
}