package com.company.sportEquipment.dao.impl;

import com.company.sportEquipment.bean.Equipment;
import com.company.sportEquipment.dao.EquipmentDAO;
import com.company.sportEquipment.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLEquipmentDAO implements EquipmentDAO {

    String sql = null;// ну что это за разделяемое поле, а????
    // да и без атрибутов
    // зачет так гробить код?

    @Override
    public void addEquipment(Equipment equipment) throws DAOException {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");// драйвер грузится в память один раз
            // зачем же его грузить в каждом методе?
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/SportEquipment", "root", "Il0107");
            Statement myStm = myCon.createStatement();

            String param = "('" + equipment.getTitle() + "'," + equipment.getPrice() + "," + equipment.getAmount() + ")";
            sql = "insert into equipment (title, price, amount)" +
                    "values" + param;// PreparedStatement кто учил?

            myStm.executeUpdate(sql);
        } catch (Exception exception) {
            exception.printStackTrace();// ну кто это гасит исключение
            // причем Exception
            // мы что, не проходили как слой должен отдавать исключение другому слою?
        }
    }

    @Override
    public void rentEquipment(String request) throws DAOException {

        String title = null;
        int amount = 0;
        int id_user = 0;
        int price = 0;
        int id_equipment = 0;
        String currentSubstring = null;
        String responce = null;

        //!!!!!!!!!!!! а почему DAO парсит request
        currentSubstring = request.substring(request.indexOf("title"));// именуем константные строки
        title = currentSubstring.substring(6, currentSubstring.indexOf(' '));

        currentSubstring = request.substring(request.indexOf("amount"));
        currentSubstring = currentSubstring.substring(7, currentSubstring.indexOf(' '));
        amount = Integer.parseInt(currentSubstring);

        currentSubstring = request.substring(request.indexOf("id"));
        currentSubstring = currentSubstring.substring(3);
        id_user = Integer.parseInt(currentSubstring);

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/SportEquipment", "root", "Il0107");
            Statement myStm = myCon.createStatement();

            sql = "SELECT * FROM  equipment WHERE (title = '" + title + "') AND (amount >= '" + amount + "')";
            ResultSet myRes = myStm.executeQuery(sql);

            while (myRes.next()) {
                price = myRes.getInt("price");
                id_equipment = myRes.getInt("id_equipment");
            }

            if (id_equipment > 0) {

                String param = "(" + id_user + "," + id_equipment + "," +
                        amount + "," + amount * price + ")";
                sql = "insert into rented (id_users, id_equipments, rented_amount, total_price)" +
                        "values" + param;
                myStm.executeUpdate(sql);
            } else {
                responce = "Not found";// у тебя метод void возвращает
                // причем тут response?
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if(responce=="Not found"){// все, я убита
            // кто так сравнивает строки?
            throw new DAOException("There are no such equipment");
        }
    }// бред какой-то в коде, если честно

    @Override
    public void returnEquipment(String request) throws DAOException {
        String title = null;
        int id_user = 0;
        int id_equipment = 0;
        String currentSubstring = null;

        currentSubstring = request.substring(request.indexOf("title"));
        title = currentSubstring.substring(6, currentSubstring.indexOf(' '));

        currentSubstring = request.substring(request.indexOf("id"));
        currentSubstring = currentSubstring.substring(3);
        id_user = Integer.parseInt(currentSubstring);

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/SportEquipment", "root", "Il0107");
            Statement myStm = myCon.createStatement();

            sql = "SELECT * FROM  equipment WHERE (title = '" + title + "')";
            ResultSet myRes = myStm.executeQuery(sql);

            while (myRes.next()) {
                id_equipment = myRes.getInt("id_equipment");
            }

            sql = "delete from rented where (id_equipments ='" + id_equipment + "') and (id_users='" + id_user + "')";
            int rowAffected = myStm.executeUpdate(sql);

            System.out.println(rowAffected);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
