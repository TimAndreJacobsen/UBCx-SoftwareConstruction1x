package model.library;

import model.book.Book;

public class Librarian {

    private String name;
    private int age;
    private Library managingLibrary;
    private Book favBook;

    public Librarian(String name, int age, Library lib, Book favBook) {
        this.name = name;
        this.age = age;
        this.managingLibrary = lib;
        this.favBook = favBook;
    }

    // getters
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public Library getManagingLibrary() {
        return this.managingLibrary;
    }
    public Book getFavBook() {
        return this.favBook;
    }

    // REQUIRES: lib != null
    // MODIFIES: this
    // EFFECTS: changes this librarian's managing library to the one given.
    //          Look carefully at the implementation of library - does it
    //          also have an associated librarian field? Does it make a
    //          difference in the implementation of this method?
    public void changeLibrary(Library lib) {
        // changed method return from bool to void
        this.managingLibrary = lib;
        lib.hireLibrarian(this);
    }


}
