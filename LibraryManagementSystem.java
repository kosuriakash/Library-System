import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem{

    static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        // Add some initial books
        Book book1 = new Book(1, "Harry Potter", "J.K.Rowling");
        Book book2 = new Book(2, "THE HOUSE OF WOLVES", " James Patterson");
        Book book3 = new Book(3, "FAIRY TALE", "Stephen King");
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---Library Management System---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.out.println("Good Bye.... Come Again");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
                    break;
            }
        } while (choice != 4);

        sc.close();
    }

    public static void addBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the book title: ");
        String title = sc.nextLine();

        System.out.print("Enter the book author: ");
        String author = sc.nextLine();

        Book book = new Book(id, title, author);
        books.add(book);

        System.out.println("Book added successfully!");
    }

    public static void removeBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library!");
        } else {
            System.out.println("\n---List of Books---");
            System.out.println("ID\tTitle\t\t\tAuthor");
            System.out.println("--\t-----\t\t\t------");
            for (Book book : books) {
                System.out.println(String.format("%d\t%-20s\t%s", book.getId(), book.getTitle(), book.getAuthor()));
            }
        }
    }
}

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
