package com.company.sportEquipment.dao.impl;

import com.company.sportEquipment.bean.User;
import com.company.sportEquipment.dao.UserDAO;
import com.company.sportEquipment.dao.exception.DAOException;

import java.sql.*;

public class SQLUserDAO implements UserDAO {

    @Override
    public String signIn(String login, String password) throws DAOException {

        String result = null;
        try {

            Class.forName("org.gjt.mm.mysql.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/SportEquipment", "root", "Il0107");
            Statement myStm = myCon.createStatement();

            String sql = "SELECT * FROM  user WHERE (password = '" + password + "') AND (login = '" + login + "')";
            ResultSet myRes = myStm.executeQuery(sql);

            while (myRes.next()) {
                result = myRes.getString("name") + " " + myRes.getString("surname")
                        + " id=" + myRes.getString("id_user");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return result;
    }

    @Override
    public void registration(User user) throws DAOException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/SportEquipment", "root", "Il0107");
            Statement myStm = myCon.createStatement();

            String sql = "SELECT * FROM  user WHERE (password = '" + user.getPassword()
                    + "') AND (login = '" + user.getLogin() + "')";
            ResultSet myRes = myStm.executeQuery(sql);

            if (!myRes.next()) {
                System.out.println("Not find this login, you can registration");

                String userInformation = "('" + user.getName() + "','" + user.getSurname() + "','"
                        + user.getLogin() + "','" + user.getPassword() + "')";
                sql = "insert into user (name, surname, login, password)" +
                        "values" + userInformation;

                myStm.executeUpdate(sql);
            } else {
                System.out.println("This login is used, try again");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
