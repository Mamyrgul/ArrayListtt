package service;

import models.Reader;

import java.util.ArrayList;
import java.util.List;

public interface ReaderService {
    void saveReader(Reader reader);
    ArrayList<Reader> getAllReaders();
    Reader getReaderById(Long id);
    Reader updateReader(Long id, Reader reader);
    void assignReaderToLibrary(Long readerId, Long libraryId);
}
