package com.company.sportEquipment.service.impl;

import com.company.sportEquipment.bean.User;
import com.company.sportEquipment.dao.UserDAO;
import com.company.sportEquipment.dao.exception.DAOException;
import com.company.sportEquipment.dao.factory.DAOFactory;
import com.company.sportEquipment.service.ClientService;
import com.company.sportEquipment.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

    @Override
    public String singIn(String login, String password) throws ServiceException {
        String id  = null;
        if (login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
        if (password == null || password.isEmpty()) {
            throw new ServiceException("Incorrect password");
        }

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            id = userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return id;
    }


    @Override
    public void registration(User user) throws ServiceException {

        if (user == null) {
            throw new ServiceException("Incorrect data");
        }

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
