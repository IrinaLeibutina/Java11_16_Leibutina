package com.company.sportEquipment.service.impl;

import com.company.sportEquipment.bean.Equipment;
import com.company.sportEquipment.dao.EquipmentDAO;
import com.company.sportEquipment.dao.exception.DAOException;
import com.company.sportEquipment.dao.factory.DAOFactory;
import com.company.sportEquipment.service.ShopService;

import com.company.sportEquipment.service.exception.ServiceException;

public class ShopServiceImpl implements ShopService {

    @Override
    public void addNewEquipment(Equipment equipment) throws ServiceException {

        if (equipment == null) {// валидаыия в сервичах - это не только проверка на null
            // это действительная проверка корректности всех пришедших параметров
            throw new ServiceException("Incorrect data");
        }

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            EquipmentDAO equipmentDAO = daoObjectFactory.getEquipmentsDAO();
            equipmentDAO.addEquipment(equipment);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void rentEquipment(String request) throws ServiceException {

        if (request == null || request.isEmpty()) {
            throw new ServiceException("Incorrect request");
        }

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            EquipmentDAO equipmentDAO = daoObjectFactory.getEquipmentsDAO();
            equipmentDAO.rentEquipment(request);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void returnEquipment(String request) throws ServiceException {

        if (request == null || request.isEmpty()) {
            throw new ServiceException("Incorrect request");
        }

        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            EquipmentDAO equipmentDAO = daoObjectFactory.getEquipmentsDAO();
            equipmentDAO.returnEquipment(request);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
