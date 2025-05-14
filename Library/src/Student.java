import java.util.ArrayList;
import java.util.*;

public class Student extends User {

    private int StudentID;
    private List<Book> booksBorrowed = new ArrayList<>();

    public Student(String name, String email, String phone, int studentID, String password) {
        super(name, email, phone, password);
        this.StudentID = studentID;
    }
    public static Student createStudent(Scanner in) {
        int id = Main.getIntInput(in, "Enter student ID: ");
        String password = Main.getStringInput(in, "Enter password: ");
        String name = Main.getStringInput(in, "Enter Name: ");
        String email = Main.getStringInput(in, "Enter email: ");
        String phoneNo = Main.getStringInput(in, "Enter Phone Number: ");
        return new Student(name, email, phoneNo, id, password);
    }

    public int getStudentID() {return StudentID;}
    public List<Book> getBooksBorrowed() {return booksBorrowed;}

    public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }
    public void returnBook(Book book) {
        if(booksBorrowed.contains(book)) {
            booksBorrowed.remove(book);
            System.out.println("Book returned Successfully.");
            return;
        }
        else {
            System.out.println("Error: Book is not borrowed.");
        }

    }



    public void displayStudent() {
        System.out.println("Student ID: " + StudentID);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
    }
    public void displayBooksBorrowed() {
        if(booksBorrowed.isEmpty()) {
            System.out.println("No books borrowed.");
            return;
        }
        System.out.println("-----------------------");
        System.out.println("Books Borrowed: ");
        for (Book b : booksBorrowed) {
            System.out.println("Title: " + b.getTitle());
            System.out.println("Author: " + b.getAuthor());
            System.out.println("Book ID: " + b.getBookId());
        }
        System.out.println();
        System.out.println("-----------------------");
    }

}
