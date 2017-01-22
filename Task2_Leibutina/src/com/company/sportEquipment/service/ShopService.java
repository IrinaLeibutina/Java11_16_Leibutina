package com.company.sportEquipment.service;

import com.company.sportEquipment.bean.Equipment;
import com.company.sportEquipment.service.exception.ServiceException;

public interface ShopService {

     void addNewEquipment(Equipment equipment) throws ServiceException;
     void rentEquipment(String request) throws ServiceException;
     void returnEquipment(String request) throws ServiceException;
}
