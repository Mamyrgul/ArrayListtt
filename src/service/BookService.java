package service;

import models.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    Book saveBook(Long libraryId, Book book);
    ArrayList<Book> getAllBooks(Long libraryId);
    Book getBookById(Long libraryId, Long bookId);
    String deleteBook(Long libraryId, Long bookId);
    void clearBooksByLibraryId(Long libraryId);
}
