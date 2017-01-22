package com.company.sportEquipment.dao;

import com.company.sportEquipment.bean.User;
import com.company.sportEquipment.dao.exception.DAOException;

public interface UserDAO {

    String signIn(String login, String password) throws DAOException;
    void registration(User user) throws DAOException;
}
