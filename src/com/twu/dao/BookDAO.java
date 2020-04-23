package com.twu.dao;
import com.twu.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book>{

    private List<Book> bookList;

    @Override
    public List<Book> getAll() {
        bookList = new ArrayList();

        bookList.add(new Book(1,"Harry Potter and the Philosopher's Stone", "J.K. Rowling","Rocco", 1997 ));
        bookList.add(new Book(2,"Harry Potter and the Chamber of Secrets", "J.K. Rowling","Rocco", 1998 ));
        bookList.add(new Book(3,"Harry Potter and the Prisoner of Azkaban", "J.K. Rowling","Rocco", 1999 ));
        bookList.add(new Book(4,"Harry Potter and the Goblet of Fire", "J.K. Rowling","Rocco", 2000 ));
        bookList.add(new Book(5,"Harry Potter and the Order of the Phoenix", "J.K. Rowling","Rocco", 2003 ));
        bookList.add(new Book(6,"Harry Potter and the Half-Blood Prince", "J.K. Rowling","Rocco", 2005 ));
        bookList.add(new Book(7,"Harry Potter and the Deathly Hallows", "J.K. Rowling","Rocco", 2007 ));

        bookList.add(new Book(8,"The Lord of the Rings - The Fellowship of the Ring", "J.R.R. Tolkien","Allen & Unwin", 1954 ));
        bookList.add(new Book(9,"The Lord of the Rings - The Two Towers", "J.R.R. Tolkien","Allen & Unwin", 1954 ));
        bookList.add(new Book(10,"The Lord of the Rings - The Return of the King", "J.R.R. Tolkien","Allen & Unwin", 1955 ));

        return bookList;
    }
}
