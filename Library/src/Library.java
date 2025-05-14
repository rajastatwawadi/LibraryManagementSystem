import java.util.*;

public class Library {
    private List<Book> booksList = new ArrayList<>();
    private Map<Integer, Student> studentsList = new HashMap<>();
    private Map<Integer, Librarian> librariansList = new HashMap<>();

    Library(){;}
    public Student getStudent(int studentId, String password) throws Exception {
        Student s1 = studentsList.get(studentId);
        if (s1 == null) throw new Exception("Invalid User ID.");
        if (!password.equals(s1.getPassword())) throw new Exception("Invalid Password.");
        return s1;
    }
    public Librarian getLibrarian(int librarianId, String password) throws Exception {
        Librarian l1 = librariansList.get(librarianId);
        if (l1 == null) throw new Exception("Invalid User ID.");
        if (!password.equals(l1.getPassword())) throw new Exception("Invalid Password.");
        return l1;
    }

    public void addStudent(int studentId, Student student) {
        studentsList.put(studentId,student);
    }
    public void addLibrarian(int librarianId, Librarian librarian) {
        librariansList.put(librarianId, librarian);
    }

    public void addBook(Book book){
        booksList.add(book);
        System.out.println("Book added successfully.");
    }
    public void removeBook(int bookID) throws Exception {
        for (Book book : booksList) {
            if (book.getBookId() == bookID) {
                booksList.remove(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        throw new Exception("Book does not exist.");
    }
    public void borrowBook(int studentId, int bookId) throws Exception {
        Book b1 = findBook(bookId);
        Student s1 = studentsList.get(studentId);
        if (b1 == null) throw new Exception("Book ID not found.");
        if (s1 == null) throw new Exception("Student ID not found.");
        b1.borrowBook();
        s1.borrowBook(b1);
        System.out.println("Book borrowed successfully.");
    }
    public void returnBook(int studentId, int bookId) throws Exception {
        Book b1 = findBook(bookId);
        Student s1 = studentsList.get(studentId);
        if (b1 == null) throw new Exception("Book ID incorrect.");
        if (s1 == null) throw new Exception("Student ID incorrect.");
        b1.returnBook();
        s1.returnBook(b1);
    }

    public Book findBook(int bookId) {
        for (Book b : booksList) {
            if (b.getBookId() == bookId) return b;
        }
        return null;
    }

    /*Remove student badme dekte*/

    public void dispStudentsList() {
        if (studentsList.isEmpty()){
            System.out.println("No students found.");
            return;
        }
        System.out.println("-----------------------------------");
        System.out.println("Student list:");
        for (Student student : studentsList.values()) {
            student.displayStudent();
            student.displayBooksBorrowed();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    public void BooksListDisplay() {
        System.out.println("-------------------------------------");
        System.out.println("Books List: ");
        for (Book b : booksList) {
            b.displayBook();
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }

}
