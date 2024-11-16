package serviceImpl;

import database.DataBase;
import models.Book;
import models.Library;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements service.BookService {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
           if (library!=null){
               library.getBooks().add(book);
               return book;
           }
            return null;
    }

    @Override
    public ArrayList<Book> getAllBooks(Long libraryId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        if (library!=null){
            return library.getBooks();
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        if (library!=null){
            for (Book book:library.getBooks()){
                if (book.getId().equals(bookId)){
                    return book;
                }
            }
        }return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        if (library!=null){
            for (Book book:library.getBooks()){{
                if (book.getId().equals(bookId)){
                    library.getBooks().remove(book);
                    return "Book deleted successfully";
                }
            }
            }
        }return "Try again";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
      Library library = new LibraryServiceImpl().getLibraryById(libraryId);
      if (library!=null){
          library.getBooks().clear();
      }
    }
}
