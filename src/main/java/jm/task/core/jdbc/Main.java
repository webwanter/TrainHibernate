package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Johny", "Silverhand", (byte) 34);

        userService.saveUser("Spider", "Murphy", (byte) 28);

        userService.saveUser("Morgan", "Blackhand", (byte) 37);

        userService.saveUser("Adam", "Smasher", (byte) 41);


        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        Util.closeSessionFactory();

    }
}
