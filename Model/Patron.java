package Model;

public class Patron {
    public String name;
    public int id;
    public String details; 

    public Patron (String name, int id, String details){
        this.name = name;
        this.id = id;
        this.details = details;
    }

    public void displayPatron() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Contact details: " + details);
    }

}
