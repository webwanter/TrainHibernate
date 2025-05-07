package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.Book;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookStoreDaoHibernateImpl implements BookStoreDao {


    public BookStoreDaoHibernateImpl() {
    }

    @Override
    public void createBookStoreTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql1 = "CREATE TABLE IF NOT EXISTS books (" +
                    "  `book_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `title` VARCHAR(45) NOT NULL," +
                    "  `author_id` INT NOT NULL," +
                    "  `price` INT NOT NULL," +
                    "  `amount` INT NOT NULL," +
                    "  PRIMARY KEY (`book_id`)" +
                    ");";

            String sql2 = "CREATE TABLE IF NOT EXISTS buys (" +
                    "  `buy_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `buy_description` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`buy_id`)" +
                    ");";

            String sql3 = "CREATE TABLE IF NOT EXISTS buy_book (" +
                    "  `buy_book_id` INT NOT NULL," +
                    "  `buy_id` INT NOT NULL," +
                    "  `book_id` INT NOT NULL," +
                    "  `amount` INT NOT NULL," +
                    "  PRIMARY KEY (`buy_book_id`)," +
                    "  FOREIGN KEY (`buy_id`) REFERENCES buys(`buy_id`)," +
                    "  FOREIGN KEY (`book_id`) REFERENCES books(`book_id`)" +
                    ");";

            session.createSQLQuery(sql1).executeUpdate();
            session.createSQLQuery(sql2).executeUpdate();
            session.createSQLQuery(sql3).executeUpdate();

            transaction.commit();
            System.out.println("Created tables successfully");
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void dropBookStoreTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String sql1 = "DROP TABLE IF EXISTS buy_book;";
            String sql2 = "DROP TABLE IF EXISTS buys;";
            String sql3 = "DROP TABLE IF EXISTS books;";

            session.createSQLQuery(sql1).executeUpdate();
            session.createSQLQuery(sql2).executeUpdate();
            session.createSQLQuery(sql3).executeUpdate();
            transaction.commit();
            System.out.println("Dropped books table");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveBook(String title, Long authorId, int price, int amount) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new Book(title, authorId, price, amount));
            transaction.commit();
            System.out.println("Book with title — " + title + " added to database");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeBookById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
                System.out.println("Book with id " + id + " is removed");
            } else {
                System.out.println("Book with id " + id + " not found");
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void cleanBookStoreTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("delete from Book").executeUpdate();
            transaction.commit();
            System.out.println("Table cleared");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
