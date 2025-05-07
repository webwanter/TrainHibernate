package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookStoreService {
    void createBookStoreTable() throws SQLException;

    void dropBookStoreTable() throws SQLException;

    void saveBook(String title, Long authorId, int price, int amount) throws SQLException;

    void removeBookById(long id) throws SQLException;

    List<Book> getAllBooks() throws SQLException;

    void cleanBookStoreTable() throws SQLException;
}
