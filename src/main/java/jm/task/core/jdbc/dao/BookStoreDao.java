package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.Book;

import java.util.List;

public interface BookStoreDao {
    void createBookStoreTable();

    void dropBookStoreTable();

    void saveBook(String title, Long author_id, int price, int amount);

    void removeBookById(long id);

    List<Book> getAllBooks();

    void cleanBookStoreTable();
}
