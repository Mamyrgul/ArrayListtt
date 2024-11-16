package serviceImpl;

import database.DataBase;
import models.Library;
import models.Reader;

import java.util.ArrayList;

public class ReaderServiceImpl implements service.ReaderService {
    @Override
    public void saveReader(Reader reader) {
        System.out.println(DataBase.readers.add(reader));
    }

    @Override
    public ArrayList<Reader> getAllReaders() {
        return DataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader:DataBase.readers){
            if (reader.getId().equals(id)){
                return reader;
            }
        }return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
     for (Reader reader1: DataBase.readers){
         if (reader1.getId().equals(id)){
             return reader1;
         }
     }return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        Reader reader = new ReaderServiceImpl().getReaderById(readerId);
        if (library!=null && reader!=null){
            System.out.println(library.getReaders().add(reader));
        }
    }
}
