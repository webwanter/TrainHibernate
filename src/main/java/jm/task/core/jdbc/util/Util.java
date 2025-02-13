package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String USER = "webscout";
    private static final String PASSWORD = "aq1";
    private static Connection con = null;
    private static SessionFactory sessionFactory;

    private Util() {
    }

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null && !con.isClosed()) {
                System.out.println("Connection established");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties props = new Properties();
                props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                props.put(Environment.URL, URL);
                props.put(Environment.USER, USER);
                props.put(Environment.PASS, PASSWORD);
                props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                props.put(Environment.SHOW_SQL, "true");
                props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                props.put(Environment.HBM2DDL_AUTO, "create-drop");

                Configuration config = new Configuration()
                        .setProperties(props)
                        .addAnnotatedClass(User.class);

                sessionFactory = config.buildSessionFactory();
                System.out.println("SessionFactory created");
            } catch (Exception e) {
                System.out.println("SessionFactory creation failed");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        System.out.println("SessionFactory closed");
    }


}
