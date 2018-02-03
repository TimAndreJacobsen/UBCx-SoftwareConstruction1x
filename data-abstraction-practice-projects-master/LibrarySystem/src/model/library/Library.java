package model.library;

import model.book.Book;
import model.book.BookType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static model.book.BookType.*;

public class Library {

    private Librarian manager;
    private String name;
    private List<Library> branches;
    private List<Book> referenceBooks;
    private List<Book> fictionBooks;
    private List<Book> nonfictionBooks;
    private List<Book> textBooks;
    private List<Book> cookBooks;

    public Library(String name, Librarian manager) {
        this.name = name;
        this.manager = manager;
        initializeGenres();
    }


    // getters
    public String getName() {
        return this.name;
    }
    public Librarian getManager() {
        return this.manager;
    }

    // REQUIRES: bk != null
    // MODIFIES: this
    // EFFECTS: stores the given Book bk into the appropriate container within this class
    public boolean addBook(Book bk) {

        if (bk.getType().equals(REFERENCE)) {
            referenceBooks.add(bk);
            return true;

        } else if (bk.getType().equals(BookType.FICTION)) {
            fictionBooks.add(bk);
            return true;

        } else if (bk.getType().equals(BookType.NONFICTION)) {
            nonfictionBooks.add(bk);
            return true;

        } else if (bk.getType().equals(TEXTBOOK)) {
            textBooks.add(bk);
            return true;

        } else if (bk.getType().equals(COOKING)) {
            cookBooks.add(bk);
            return true;

        }
        return false;
    }

    // REQUIRES: bk != null
    // EFFECTS: return true if the given book is in the catalogue,
    //          regardless of its loan status, else return false
    public boolean inCatalogue(Book bk) {
        if (bk.getType().equals(REFERENCE)) {
            return inCatalogueHelper_CheckTypeList(referenceBooks, bk);

        } else if (bk.getType().equals(BookType.FICTION)) {
            return inCatalogueHelper_CheckTypeList(fictionBooks, bk);

        } else if (bk.getType().equals(BookType.NONFICTION)) {
            return inCatalogueHelper_CheckTypeList(nonfictionBooks, bk);

        } else if (bk.getType().equals(TEXTBOOK)) {
            return inCatalogueHelper_CheckTypeList(textBooks, bk);

        } else if (bk.getType().equals(COOKING)) {
            return inCatalogueHelper_CheckTypeList(cookBooks, bk);
        }
        return false;
    }

    // REQUIRES: bk != null, onLoan == false (cant loan out a book thats already loaned out)
    // EFFECTS: return true if the given book is available to loan, false if already on loan.
    public boolean canLoan(Book bk) {
        if (bk.onLoan()) {
            return false;
        }
        return true;
    }

    // REQUIRES: bk != null
    // EFFECTS: return true if the given book is available in the catalogue of this library's
    //          other branches; else, return false
    public boolean isInDiffBranch(Book bk) {
        for (Library lib : branches) {
            if (lib.inCatalogue(bk)) {
                return true;
            }
        }
        return false;
    }

    // REQUIRES: bk != null
    // MODIFIES: this
    // EFFECTS: set bk as being checked out from this library if possible
    //          return true if successful, else false
    public boolean checkOutBook(Book bk) {
        bk.nowOnLoan();
        if (bk.onLoan()) {
            return true;
        }
        return false;
    }

    // REQUIRES: bk != null
    // MODIFIES: this
    // EFFECTS: set bk as being back in the library if it has been borrowed previously
    //          return true if successful, otherwise false
    public boolean returnBook(Book bk) {
        bk.notOnLoan();
        if (bk.onLoan()) {
            return false;
        }
        return true;
    }

    // REQUIRES: manager != null
    // MODIFIES: this
    // EFFECTS: sets this library's librarian to manager; return true if successful, else false
    public boolean hireLibrarian(Librarian manager) {
        // Always returns true, change return type?
        this.manager = manager;
        return true;
    }

    // Utility method, do not touch its implementation
    public void printCatalogue() {
        List<Book> totalCatalogue = new LinkedList<>();
        totalCatalogue.addAll(this.cookBooks);
        totalCatalogue.addAll(this.fictionBooks);
        totalCatalogue.addAll(this.nonfictionBooks);
        totalCatalogue.addAll(this.textBooks);
        totalCatalogue.addAll(this.referenceBooks);

        for (Book b : totalCatalogue) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }
    }

    // REQUIRES: Library != null, used in Library constructor
    // MODIFIES: this
    // EFFECTS : Initializes a new ArrayList for every genre
    private void initializeGenres() {
        referenceBooks = new ArrayList<Book>();
        fictionBooks = new ArrayList<Book>();
        nonfictionBooks = new ArrayList<Book>();
        textBooks = new ArrayList<Book>();
        cookBooks = new ArrayList<Book>();
    }

    // REQUIRES: List != null, Book != null
    // EFFECTS : If book is in list<BookType> return true, else return false
    private boolean inCatalogueHelper_CheckTypeList(List<Book> type, Book book) {
        for (Book b : type) {
            if (book.equals(b)) {
                return true;
            }
        }
        return false;
    }
}
