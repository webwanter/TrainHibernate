package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.BookStoreDao;
import jm.task.core.jdbc.dao.BookStoreDaoHibernateImpl;
import jm.task.core.jdbc.model.Book;

import java.util.List;

public class BookStoreServiceImpl implements BookStoreService {


    private final BookStoreDao bookStoreDao = new BookStoreDaoHibernateImpl();

    public BookStoreServiceImpl() {
    }

    @Override
    public void createBookStoreTable() {
        bookStoreDao.createBookStoreTable();
    }

    @Override
    public void dropBookStoreTable() {
        bookStoreDao.dropBookStoreTable();
    }

    @Override
    public void saveBook(String title, Long authorId, int price, int amount) {
        bookStoreDao.saveBook(title, authorId, price, amount);
    }

    @Override
    public void removeBookById(long id) {
        bookStoreDao.removeBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookStoreDao.getAllBooks();
    }

    @Override
    public void cleanBookStoreTable() {
        bookStoreDao.cleanBookStoreTable();
    }
}
