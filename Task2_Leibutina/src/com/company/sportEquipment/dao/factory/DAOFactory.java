package com.company.sportEquipment.dao.factory;


import com.company.sportEquipment.dao.EquipmentDAO;
import com.company.sportEquipment.dao.UserDAO;
import com.company.sportEquipment.dao.impl.SQLEquipmentDAO;
import com.company.sportEquipment.dao.impl.SQLUserDAO;

public final class DAOFactory {

    private static final DAOFactory daoFactory = new DAOFactory();

    private DAOFactory() {
    }

    private UserDAO userDAO = new SQLUserDAO();
    private EquipmentDAO equipmentsDAO = new SQLEquipmentDAO();

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public EquipmentDAO getEquipmentsDAO() {
        return equipmentsDAO;
    }

    public static DAOFactory getInstance() {
        return daoFactory;
    }
}