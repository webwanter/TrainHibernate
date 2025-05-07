//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.Book;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//


// Outdated component, not working


//public class BookDaoJDBCImpl implements BookDao {
//
//    private final Connection con;
//
//
//    public BookDaoJDBCImpl() {
//        this.con = Util.getConnection();
//    }
//
//    @Override
//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users  (\n" +
//                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                "  `name` VARCHAR(45) NOT NULL,\n" +
//                "  `lastName` VARCHAR(45) NOT NULL,\n" +
//                "  `age` INT(3) NOT NULL,\n" +
//                "  PRIMARY KEY (`id`));";
//
//        try (Statement stmt = con.createStatement()) {
//            stmt.execute(sql);
//            System.out.println("Table created");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users;";
//
//        try (Statement stmt = con.createStatement()) {
//            stmt.execute(sql);
//            System.out.println("Table dropped");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO  users (name, lastName, age) VALUES (?,?,?)";
//
//        try (PreparedStatement ps = con.prepareStatement(sql);) {
//            con.setAutoCommit(false);
//            ps.setString(1, name);
//            ps.setString(2, lastName);
//            ps.setByte(3, age);
//
//            ps.executeUpdate();
//            con.commit();
//            System.out.println("User с именем — " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//                System.out.println("Transaction rolled back");
//
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        String sql = "DELETE  FROM users WHERE id = ?";
//
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            con.setAutoCommit(false);
//            ps.setLong(1, id);
//
//            ps.executeUpdate();
//            con.commit();
//            System.out.println("User with id " + id + " is removed");
//
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//                System.out.println("Transaction rolled back");
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public List<Book> getAllUsers() {
//        List<Book> books = new ArrayList<Book>();
//
//        String sql = "SELECT * FROM users";
//
//        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
//
//            while (rs.next()) {
//                Book book = new Book();
//                book.setId(rs.getLong("id"));
//                book.setName(rs.getString("name"));
//                book.setLastName(rs.getString("lastName"));
//                book.setAge(rs.getByte("age"));
//                books.add(book);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return books;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        String sql = "TRUNCATE  TABLE users;";
//
//        try (Statement stmt = con.createStatement()) {
//            stmt.execute(sql);
//            System.out.println("Table cleared");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
