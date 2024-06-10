package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Book {
    private int bookID;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;



    public Book(int bookID, String title, String author, int totalCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.availableCopies = totalCopies;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void decreaseAvailableCopies() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    public void increaseAvailableCopies() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }
}

class Member {
    private int memberID;
    private String name;
    private int age;
    private String phoneNumber;
    private List<Book> borrowedBooks;
    private Map<Book, LocalDate> bookBorrowDates = new HashMap<>(); // Track borrow dates for books
    private double fineAmount;

    public Member(int memberID, String name, int age, String phoneNumber) {
        this.memberID = memberID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
        this.fineAmount = 0;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void borrowBook(Book book) {
        if (fineAmount == 0 && borrowedBooks.size() < 2 && book.getAvailableCopies() > 0) {
            // Check if member has previously borrowed books
            if (!bookBorrowDates.isEmpty()) {
                LocalDate currentDate = LocalDate.now();
                for (Book borrowedBook : bookBorrowDates.keySet()) {
                    LocalDate borrowDate = bookBorrowDates.get(borrowedBook);
                    long daysElapsed = ChronoUnit.DAYS.between(borrowDate, currentDate);
                    if (daysElapsed < 10) {
                        System.out.println("Cannot borrow another book within 10 days of the previous borrow.");
                        return;
                    }
                }
            }

            borrowedBooks.add(book);
            book.decreaseAvailableCopies();
            bookBorrowDates.put(book, LocalDate.now()); // Record the borrow date
        }
    }



    public void returnBook(Book book, int daysLate) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.increaseAvailableCopies();
            double fine = daysLate * 3.0;
            fineAmount += fine;
            System.out.println("Book ID: " + book.getBookID() + " successfully returned. " +
                    fine + " Rupees has been charged for a delay of " + daysLate + " days.");
        }
    }

    public void payFine() {
        if (fineAmount > 0) {
            System.out.println("You had a total fine of Rs. " + fineAmount + ". It has been paid successfully!");
            fineAmount = 0;
        }
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;
    private int nextBookID;
    private int nextMemberID;
    private Member loggedInMember;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.nextBookID = 1;
        this.nextMemberID = 1;
        this.loggedInMember = null;
    }

    public void addBook(String title, String author, int totalCopies) {
        int lastBookID = 0;
        if (!books.isEmpty()) {
            // Get the last Book ID in the library
            lastBookID = books.get(books.size() - 1).getBookID();
        }

        for (int i = 1; i <= totalCopies; i++) {
            int newBookID = lastBookID + i; // Generate a new Book ID
            Book newBook = new Book(newBookID, title, author, 1); // Initialize with 1 available copy
            books.add(newBook);
        }

        System.out.println("Book(s) added successfully!");
    }

    public void removeBook(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                books.remove(book);
                System.out.println("Book Removed Successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    public void registerMember(String name, int age, String phoneNumber) {
        Member member = new Member(nextMemberID++, name, age, phoneNumber);
        members.add(member);
        System.out.println("Member Successfully Registered with Member ID: " + member.getMemberID() + "!");
    }

    public void removeMember(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                members.remove(member);
                System.out.println("Member Removed Successfully!");
                return;
            }
        }
        System.out.println("Member with ID " + memberID + " not found.");
    }

    public void loginAsMember(String name, String phoneNumber) {
        for (Member member : members) {
            if (member.getName().equals(name) && member.getPhoneNumber().equals(phoneNumber)) {
                loggedInMember = member;
                System.out.println("Welcome " + member.getName() + ". Member ID: " + member.getMemberID());
                return;
            }
        }
        System.out.println("Member with Name: " + name + " and Phone No: " + phoneNumber + " doesn't exist.");
    }

    public void listAvailableBooks() {
        System.out.println("List of Available Books:");
        for (Book book : books) {
            if (book.getAvailableCopies() > 0) {
                System.out.println("Book ID: " + book.getBookID() + ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor());
            }
        }
    }

    public void listMyBooks() {
        if (loggedInMember != null) {
            System.out.println("List of Borrowed Books by " + loggedInMember.getName() + ":");
            List<Book> borrowedBooks = loggedInMember.getBorrowedBooks();
            if (borrowedBooks.isEmpty()) {
                System.out.println("No books borrowed.");
            } else {
                for (Book book : borrowedBooks) {
                    System.out.println("Book ID: " + book.getBookID() + ", Title: " + book.getTitle() +
                            ", Author: " + book.getAuthor());
                }
            }
        } else {
            System.out.println("Not logged in as a member.");
        }
    }

    public void issueBook(int bookID) {
        if (loggedInMember != null) {
            for (Book book : books) {
                if (book.getBookID() == bookID) {
                    loggedInMember.borrowBook(book);
                    System.out.println("Book Issued Successfully!");
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found.");
        } else {
            System.out.println("Not logged in as a member.");
        }
    }

    public void returnBook(int bookID, int daysLate) {
        if (loggedInMember != null) {
            for (Book book : loggedInMember.getBorrowedBooks()) {
                if (book.getBookID() == bookID) {
                    loggedInMember.returnBook(book, daysLate);
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found in your borrowed books.");
        } else {
            System.out.println("Not logged in as a member.");
        }
    }

    public void payFine() {
        if (loggedInMember != null) {
            loggedInMember.payFine();
        } else {
            System.out.println("Not logged in as a member.");
        }
    }

    public void calculateFine(int daysLate) {
        if (daysLate > 0) {
            double fineAmount = daysLate * 3.0;
            System.out.println("Fine for a delay of " + daysLate + " days: Rs. " + fineAmount);
        } else {
            System.out.println("No fine applicable.");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Library Portal Initialized….");
        System.out.println("---------------------------------");

        while (true) {
            System.out.println("1.  Enter as a librarian");
            System.out.println("2.  Enter as a member");
            System.out.println("3.  Exit");
            System.out.println("---------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Librarian
                    while (true) { // Inner loop for librarian menu
                        System.out.println("1. Register a member");
                        System.out.println("2. Remove a member");
                        System.out.println("3. Add a book");
                        System.out.println("4. Remove a book");
                        System.out.println("5. View all members along with their books and fines to be paid");
                        System.out.println("6. View all books");
                        System.out.println("7. Back");
                        System.out.println("---------------------------------");
                        int librarianChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (librarianChoice) {
                            case 1:
                                // Register a member
                                System.out.print("Name: ");
                                String name = scanner.nextLine();
                                System.out.print("Age: ");
                                int age = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                System.out.print("Phone no: ");
                                String phoneNumber = scanner.nextLine();
                                library.registerMember(name, age, phoneNumber);
                                break;
                            case 2:
                                // Remove a member
                                System.out.print("Enter Member ID: ");
                                int memberIDToRemove = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                library.removeMember(memberIDToRemove);
                                break;
                            case 3:
                                // Add a book
                                System.out.print("Title: ");
                                String bookTitle = scanner.nextLine();
                                System.out.print("Author: ");
                                String bookAuthor = scanner.nextLine();
                                System.out.print("Total copies: ");
                                int totalCopies = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                library.addBook(bookTitle, bookAuthor, totalCopies);
                                break;
                            case 4:
                                // Remove a book
                                System.out.print("Enter Book ID: ");
                                int bookIDToRemove = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                library.removeBook(bookIDToRemove);
                                break;
                            case 5:
                                // View all members along with their books and fines
                                System.out.println("Members and their details:");
                                for (Member member : library.members) {
                                    System.out.println("Member ID: " + member.getMemberID());
                                    System.out.println("Name: " + member.getName());
                                    System.out.println("Phone No: " + member.getPhoneNumber());
                                    List<Book> borrowedBooks = member.getBorrowedBooks();
                                    if (!borrowedBooks.isEmpty()) {
                                        System.out.println("Borrowed Books:");
                                        for (Book book : borrowedBooks) {
                                            System.out.println("Book ID: " + book.getBookID()
                                                    + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                                        }
                                    }
                                    double fineAmount = member.getFineAmount();
                                    System.out.println("Fine Amount: Rs. " + fineAmount);
                                }
                                break;
                            case 6:
                                // View all books
                                System.out.println("Books in the library:");
                                for (Book book : library.books) {
                                    System.out.println("Book ID: " + book.getBookID());
                                    System.out.println("Title: " + book.getTitle());
                                    System.out.println("Author: " + book.getAuthor());
                                    System.out.println("---------------------------------");
                                }
                                break;
                            case 7:
                                // Back to main menu
                                break;
                            default:
                                System.out.println("Invalid choice for librarian.");
                                break;
                        }
                        if (librarianChoice == 7) {
                            break; // Exit the librarian menu and return to the main menu
                        }
                    }
                    break;
                case 2:
                    // Member
                    System.out.print("Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Phone No: ");
                    String memberPhoneNumber = scanner.nextLine();
                    library.loginAsMember(memberName, memberPhoneNumber);
// Member menu
                    boolean exitMemberMenu = false;

                    while (!exitMemberMenu) {
                        System.out.println("1: List Available Books");
                        System.out.println("2: List My Books");
                        System.out.println("3: Issue book");
                        System.out.println("4: Return book");
                        System.out.println("5: Pay Fine");
                        System.out.println("6: Back");
                        System.out.println("---------------------------------");
                        int memberChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (memberChoice) {
                            case 1:
                                // List available books
                                library.listAvailableBooks();
                                break;
                            case 2:
                                // List borrowed books
                                library.listMyBooks();
                                break;
                            case 3:
                                // Issue a book
                                System.out.print("Enter Book ID to issue: ");
                                int bookIDToIssue = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                library.issueBook(bookIDToIssue);
                                break;
                            case 4:
                                // Return a book
                                System.out.print("Enter Book ID to return: ");
                                int bookIDToReturn = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                System.out.print("Enter days late: ");
                                int daysLate = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                library.returnBook(bookIDToReturn, daysLate);
                                break;
                            case 5:
                                // Pay fine
                                library.payFine();
                                break;
                            case 6:
                                // Back to member menu
                                exitMemberMenu = true;
                                break;
                            default:
                                System.out.println("Invalid choice for member.");
                                break;
                        }
                    }
                    // After the member menu loop
                    library.loggedInMember = null; // Log out the member
                    break;
                case 3:
                    // Exit
                    System.out.println("---------------------------------");
                    System.out.println("Thanks for visiting!");
                    System.out.println("---------------------------------");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

