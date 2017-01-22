package com.company.sportEquipment.dao;

import com.company.sportEquipment.bean.Equipment;
import com.company.sportEquipment.dao.exception.DAOException;

public interface EquipmentDAO {

    void addEquipment(Equipment equipment) throws DAOException;
    void rentEquipment(String request) throws DAOException;
    void returnEquipment(String request) throws DAOException;
}
