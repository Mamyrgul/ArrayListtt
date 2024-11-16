package serviceImpl;

import database.DataBase;
import models.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements service.LibraryService {
    @Override
    public ArrayList<Library> saveLibrary(List<Library> libraries) {
        DataBase.libraries.addAll(libraries);
        return (ArrayList<Library>) libraries;
    }

    @Override
    public ArrayList<Library> getAllLibraries() {
        return DataBase.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library:DataBase.libraries){
            if (library.getId().equals(id)){
                return library;
            }
        }return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(id)){
                DataBase.libraries.set(i,library);
                return library;
            }
        }return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        Library library = getLibraryById(id);
        if (library!=null){
            DataBase.libraries.remove(library);
            return "You successfully deleted library";
        }return "Try again";
    }
}
