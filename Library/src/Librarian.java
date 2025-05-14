import java.util.Scanner;

public class Librarian extends User{
    private int LibrarianID;

    public Librarian(String name, String email, String phone, int librarianID, String password) {
        super(name, email, phone, password);
        this.LibrarianID = librarianID;
    }

    public static Librarian createLibrarian(Scanner in) {
        int id = Main.getIntInput(in, "Enter Librarian ID: ");
        String password = Main.getStringInput(in, "Enter password: ");
        String name = Main.getStringInput(in, "Enter Name: ");
        String email = Main.getStringInput(in, "Enter email: ");
        String phoneNo = Main.getStringInput(in, "Enter Phone Number: ");
        return new Librarian(name, email, phoneNo, id, password);
    }

    public int getLibrarianID() {return LibrarianID;}


    public void displayLibrarian() {
        System.out.println("LibrarianID: " + LibrarianID);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());

    }
}
