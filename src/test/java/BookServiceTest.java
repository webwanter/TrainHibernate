//import jm.task.core.jdbc.model.Book;
//import jm.task.core.jdbc.service.BookService;
//import jm.task.core.jdbc.service.BookServiceImpl;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class BookServiceTest {
//    private final BookService bookService = new BookServiceImpl();
//
//    private final String testTitle = "Pale fire";
//    private final Long testAuthorId = 0L;
//    private final int testPrice = 500;
//    private final int testAmount = 1;
//
//    public BookServiceTest() throws SQLException {
//    }
//
//
//    @Test
//    public void dropBooksTable() {
//        try {
//            bookService.dropBooksTable();
//            bookService.dropBooksTable();
//        } catch (Exception e) {
//            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void createBooksTable() {
//        try {
//            bookService.dropBooksTable();
//            bookService.createBooksTable();
//        } catch (Exception e) {
//            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
//        }
//    }
//
//    @Test
//    public void saveBook() {
//        try {
//            bookService.dropBooksTable();
//            bookService.createBooksTable();
//            bookService.saveBook(testTitle, testAuthorId, testPrice,testAmount);
//
//            Book book = bookService.getAllBooks().get(0);
//
//            if (!testTitle.equals(book.getTitle())
//                    || testAuthorId != book.getAuthorId()
//                    || testPrice != book.getPrice()
//                    || testAmount != book.getAmount()
//            ) {
//                Assert.fail("Book был некорректно добавлен в базу данных");
//            }
//
//        } catch (Exception e) {
//            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void removeBookById() {
//        try {
//            bookService.dropBooksTable();
//            bookService.createBooksTable();
//            bookService.saveBook(testTitle, testAuthorId, testPrice,testAmount);
//            bookService.removeBookById(1L);
//        } catch (Exception e) {
//            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void getAllBooks() {
//        try {
//            bookService.dropBooksTable();
//            bookService.createBooksTable();
//            bookService.saveBook(testTitle, testAuthorId, testPrice,testAmount);
//            List<Book> bookList = bookService.getAllBooks();
//
//            if (bookList.size() != 1) {
//                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
//            }
//        } catch (Exception e) {
//            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void cleanBooksTable() {
//        try {
//            bookService.dropBooksTable();
//            bookService.createBooksTable();
//            bookService.saveBook(testTitle, testAuthorId, testPrice,testAmount);
//            bookService.cleanBooksTable();
//
//            if (bookService.getAllBooks().size() != 0) {
//                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
//            }
//        } catch (Exception e) {
//            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
//        }
//    }
//
//}
