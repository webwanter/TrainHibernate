package jm.task.core.jdbc;

import jm.task.core.jdbc.service.BookStoreService;
import jm.task.core.jdbc.service.BookStoreServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        final BookStoreService bookStoreService = new BookStoreServiceImpl();

        final String testTitle = "Pale fire";
        final Long testAuthorId = 0L;
        final int testPrice = 500;
        final int testAmount = 1;
        bookStoreService.dropBookStoreTable();
        bookStoreService.createBookStoreTable();
        Util.closeSessionFactory();

    }
}
