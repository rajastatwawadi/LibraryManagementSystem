import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Library lib = new Library();
        Scanner in = new Scanner(System.in);

        lib.addStudent(101,new Student("Rajas","rajas@gmail.com","9422953937",101,"rajas"));
        lib.addStudent(102,new Student("Harsh","harsh@gmail.com","9492154792",102,"harsh"));
        lib.addStudent(103,new Student("Sumedh","sumedh@gmail.com","9325147853",103,"sumedh"));

        lib.addLibrarian(1,new Librarian("Rahul","rahul@gmail.com","9326014789",1,"rahul"));
        lib.addBook(new Book("ABC","XY",11,true));
        lib.addBook(new Book("EFG","XZ",12,true));
        lib.addBook(new Book("HIJ","XX",13,true));


        while (true) {
            System.out.println("\n----- Welcome to our Library!-------");
            System.out.println("Available Services");
            System.out.println("1. Student Login");
            System.out.println("2. Librarian Login");
            System.out.println("3. New User Registration");
            System.out.println("4. Shut down Library");

            int choice = getIntInput(in, "Enter your choice: ");

            if (choice == 1) {
                int id = getIntInput(in, "Enter student ID: ");
                String password = getStringInput(in, "Enter password: ");

                try {
                    Student studentLoggedIn = lib.getStudent(id, password);
                    System.out.println("Student Login Successful......");
                    System.out.println("Hello " + studentLoggedIn.getName() + "!");
                    // Student menu
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("\nStudent Menu:");
                        System.out.println("1. View all books");
                        System.out.println("2. View borrowed books");
                        System.out.println("3. Borrow a book");
                        System.out.println("4. Return a book");
                        System.out.println("5. Log out");

                        int option = getIntInput(in, "Enter option: ");
                        switch (option) {
                            case 1:
                                lib.BooksListDisplay();
                                break;
                            case 2:
                                studentLoggedIn.displayBooksBorrowed();
                                break;
                            case 3:
                                int borrowId = getIntInput(in, "Enter Book ID to borrow: ");
                                try {
                                    lib.borrowBook(studentLoggedIn.getStudentID(), borrowId);

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                int returnId = getIntInput(in, "Enter Book ID to return: ");
                                try {
                                    lib.returnBook(studentLoggedIn.getStudentID(), returnId);
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                                break;
                            case 5:
                                exit = true;
                                System.out.println("Logged out....");
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }

                } catch (Exception e) {
                    // Print the actual message thrown from getStudent
                    System.out.println("Login failed: " + e.getMessage());
                    System.out.println("Exiting...");
                }
            }

            else if (choice == 2) {
                int id = getIntInput(in, "Enter librarian ID: ");
                String password = getStringInput(in, "Enter password: ");

                try {
                    Librarian librarianLoggedIn = lib.getLibrarian(id, password);
                    System.out.println("Librarian Login Successful......");
                    System.out.println("Hello " + librarianLoggedIn.getName() + "!");

                    boolean exit = false;
                    while (!exit) {
                        System.out.println("\nLibrarian Menu:");
                        System.out.println("1. View all books");
                        System.out.println("2. Add a book");
                        System.out.println("3. Remove a book");
                        System.out.println("4. List of Students");
                        System.out.println("5. Log out");

                        int option = getIntInput(in, "Enter option: ");
                        switch (option) {
                            case 1:
                                lib.BooksListDisplay();
                                break;
                            case 2:
                                Book b1 = Book.createBook(in);
                                lib.addBook(b1);
                                break;
                            case 3:
                                int bookId = getIntInput(in, "Enter Book ID to remove: ");
                                try{
                                    lib.removeBook(bookId);
                                }
                                catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                lib.dispStudentsList();
                                break;
                            case 5:
                                exit = true;
                                System.out.println("Logged out...");
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }

                }
                catch (Exception e) {
                    // Print the actual message thrown from getLibrarian
                    System.out.println("Login failed: " + e.getMessage());
                    System.out.println("Exiting...");
                }
            }
            else if (choice == 3) {
                System.out.println("Register as:");
                System.out.println("1. Student");
                System.out.println("2. Librarian");

                int usr = getIntInput(in, "Enter your choice: ");
                if (usr == 1) {
                    Student s1 = Student.createStudent(in);
                    lib.addStudent(s1.getStudentID(), s1);
                    System.out.println();
                    System.out.println("Student registered successfully.");
                    s1.displayStudent();
                }
                else if (usr == 2) {
                    Librarian l1 = Librarian.createLibrarian(in);
                    lib.addLibrarian(l1.getLibrarianID(), l1);
                    System.out.println();
                    System.out.println("Librarian registered successfully.");
                    l1.displayLibrarian();
                }
                else {
                    System.out.println("Invalid choice.");
                }

            } else if (choice == 4) {
                System.out.println("Library is shutting down. Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        in.close();
    }





    public static int getIntInput(Scanner scanner, String prompt) {
        int input = -1;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        String input = "";
        while (true) {
            System.out.print(prompt);
            input = scanner.next();
            if (!input.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Input cannot be empty. Please enter again.");
            }
        }
        return input;
    }
}
