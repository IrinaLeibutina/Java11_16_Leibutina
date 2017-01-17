package com.company.sportEquipment.service.factory;

import com.company.sportEquipment.service.ClientService;
import com.company.sportEquipment.service.ShopService;
import com.company.sportEquipment.service.impl.ClientServiceImpl;
import com.company.sportEquipment.service.impl.ShopServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ClientService clientService = new ClientServiceImpl();
    private ShopService shopService = new ShopServiceImpl();

    private ServiceFactory() {
    }

    public ClientService getClientService() {
        return clientService;
    }

    public ShopService getShopService() {
        return shopService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}

