package com.company.sportEquipment.service;

import com.company.sportEquipment.bean.User;
import com.company.sportEquipment.service.exception.ServiceException;


public interface ClientService {
    String singIn(String login, String password) throws ServiceException;
    void registration(User user) throws ServiceException;
}
