package models;

import enums.Gender;
import enums.Genre;
import service.BookService;
import service.LibraryService;
import service.ReaderService;
import serviceImpl.BookServiceImpl;
import serviceImpl.LibraryServiceImpl;
import serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   /* Models
    Library(id, name, address, List<Book>books, List<Reader>readers)
    Book(id, name, author, Genre genre)
    Reader(id, fullName, email, phoneNumber, Gender gender)
    Database(List<Library>libraries, List<Book>books,List<Reader>readers)

     2. Service

            LibraryService
    List<Library>saveLibrary(List<Library> libraries);
    List<Library>getAllLibraries();
    Library getLibraryById(Long id);
    Library updateLibrary(Long id, Library library);
    String deleteLibrary(Long id);

    BookService
    Book saveBook(Long libraryId,Book book);
    List<Book>getAllBooks(Long libraryId);
    Book getBookById(Long libraryId, Long bookId);
    String deleteBook(Long libraryId,Long bookId);
    void clearBooksByLibraryId(Long libraryId);

    ReaderService
    void saveReader(Reader reader);
    List<Reader> getAllReaders();
    Reader getReaderById(Long id);
    Reader updateReader(Long id, Reader reader);
    void assignReaderToLibrary(Long readerId,Long libraryId);

    Бардык методдор Main класска чакырылып, switch case аркылуу ирээттуу турдо консольго чыксын*/

        BookService bookService = new BookServiceImpl();
        LibraryService libraryService = new LibraryServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Add Library");
                    System.out.println("2. Get All Libraries");
                    System.out.println("3. Get Library By ID");
                    System.out.println("4. Update Library");
                    System.out.println("5. Delete Library");
                    System.out.println("6. Save books");
                    System.out.println("7. Get all books");
                    System.out.println("8. Get book by id");
                    System.out.println("9. Delete book");
                    System.out.println("10. Clear books by library ID");
                    System.out.println("11. Save reader");
                    System.out.println("12. Get all readers");
                    System.out.println("13. Get reader by id");
                    System.out.println("14. Update reader");
                    System.out.println("15. Assign reader to library");
                    System.out.println("16. Stop");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Adding a library...");
                            Library library = new Library(1L, "Osmonov Library", "Chui", new ArrayList<>(), new ArrayList<>());
                            libraryService.saveLibrary(new ArrayList<>(List.of(library)));
                            System.out.println("Library added: " + library);
                        }
                        case 2 -> {
                            System.out.println("All libraries: " + libraryService.getAllLibraries());
                        }
                        case 3 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            System.out.println("Library: " + libraryService.getLibraryById(libraryId));
                        }
                        case 4 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            Library updatedLibrary = new Library(libraryId, "Updated Library", "Updated Address", new ArrayList<>(), new ArrayList<>());
                            libraryService.updateLibrary(libraryId, updatedLibrary);
                            System.out.println("Library updated.");
                        }
                        case 5 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            System.out.println(libraryService.deleteLibrary(libraryId));
                        }
                        case 6 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            System.out.println("Adding a book...");
                            Book book = new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", Genre.FANTASY);
                            Book book1 = new Book(2L,"Hell","Maikl",Genre.POEM);
                            bookService.saveBook(libraryId, book);
                            bookService.saveBook(libraryId,book1);
                            System.out.println("Book added: " + book+book1);
                        }
                        case 7 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            System.out.println("Books in library: " + bookService.getAllBooks(libraryId));
                        }
                        case 8 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            System.out.print("Enter book ID: ");
                            Long bookId = scanner.nextLong();
                            System.out.println("Book: " + bookService.getBookById(libraryId, bookId));
                        }
                        case 9 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            System.out.print("Enter book ID: ");
                            Long bookId = scanner.nextLong();
                            System.out.println(bookService.deleteBook(libraryId, bookId));
                        }
                        case 10 -> {
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            bookService.clearBooksByLibraryId(libraryId);
                            System.out.println("All books in library cleared.");
                        }
                        case 11 -> {
                            System.out.println("Adding a reader...");
                            Reader reader = new Reader(1L, "John Doe", "john.doe@example.com", "1234567890", Gender.MALE);
                            readerService.saveReader(reader);
                            System.out.println("Reader added: " + reader);
                        }
                        case 12 -> {
                            System.out.println("All readers: " + readerService.getAllReaders());
                        }
                        case 13 -> {
                            System.out.print("Enter reader ID: ");
                            Long readerId = scanner.nextLong();
                            System.out.println("Reader: " + readerService.getReaderById(readerId));
                        }
                        case 14 -> {
                            System.out.print("Enter reader ID: ");
                            Long readerId = scanner.nextLong();
                            Reader updatedReader = new Reader(readerId, "Updated Name", "updated.email@example.com", "9876543210", Gender.FEMALE);
                            System.out.println("Reader updated: " + readerService.updateReader(readerId, updatedReader));
                        }
                        case 15 -> {
                            System.out.print("Enter reader ID: ");
                            Long readerId = scanner.nextLong();
                            System.out.print("Enter library ID: ");
                            Long libraryId = scanner.nextLong();
                            readerService.assignReaderToLibrary(readerId, libraryId);
                            System.out.println("Reader assigned to library.");
                        }
                        case 16 -> {
                            System.out.println("Exiting program...");
                            return;
                        }
                        default -> System.out.println("Invalid option.");
                    }
                }
            }
        }
