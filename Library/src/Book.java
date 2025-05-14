import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int bookId;
    private boolean isAvailable;

    Book(String title, String author, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }

    String getTitle() {return this.title;}
    String getAuthor() {return this.author;}
    int getBookId() {return bookId;}
    boolean getIsAvailable() {return isAvailable;}

    public static Book createBook(Scanner in) {
        System.out.print("Enter Book Id: ");
        int id = in.nextInt();
        System.out.print("Enter Title: ");
        String title = in.next();
        System.out.print("Enter Author: ");
        String author = in.next();
        return new Book(title,author,id,true);
    }

    public void borrowBook() throws Exception {
        if (!isAvailable) {
            throw new Exception("This book is not available.");
        }
        isAvailable = false;
    }
    public void returnBook() {
        isAvailable = true;
    }
    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Book ID: " + bookId);
        if(this.isAvailable){System.out.println("Available");}
        else {System.out.println("Not Available");}
    }
}
