/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.dao;

import com.mangroven.hotel.dao.custom.Food_PackageDAO;
import com.mangroven.hotel.dao.custom.Order_DetailDAO;
import com.mangroven.hotel.dao.custom.OrdersDAO;
import com.mangroven.hotel.dao.custom.PasswordDAO;
import com.mangroven.hotel.dao.custom.impl.CostDAOImpl;
import com.mangroven.hotel.dao.custom.impl.FoodDAOImpl;
import com.mangroven.hotel.dao.custom.impl.Food_PackageDAOImpl;
import com.mangroven.hotel.dao.custom.impl.Food_Package_DetailDAOImpl;
import com.mangroven.hotel.dao.custom.impl.GuestDAOImpl;
import com.mangroven.hotel.dao.custom.impl.Order_DetailDAOImpl;
import com.mangroven.hotel.dao.custom.impl.OrdersDAOImpl;
import com.mangroven.hotel.dao.custom.impl.PasswordDAOImpl;
import com.mangroven.hotel.dao.custom.impl.PaymentDAOImpl;
import com.mangroven.hotel.dao.custom.impl.QueryDAOImpl;
import com.mangroven.hotel.dao.custom.impl.ReservationDAOImpl;
import com.mangroven.hotel.dao.custom.impl.RoomDAOImpl;

/**
 *
 * @author tharindu
 */
public class DAOFactory {

    public enum DAOTypes {
        GUEST, FOOD, FOOD_PACKAGE, FOOD_PACKAGE_DETAIL, ORDERS, ORDER_DETAIL, PASSWORD, PAYMENT, QUEARY, RESERVATION, ROOM,COST;
    }

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType) {
            case GUEST:
                return new GuestDAOImpl();
            case FOOD:
                return new FoodDAOImpl();
            case FOOD_PACKAGE:
                return new Food_PackageDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDER_DETAIL:
                return new Order_DetailDAOImpl();
            case FOOD_PACKAGE_DETAIL:
                return new Food_Package_DetailDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case PASSWORD:
                return new PasswordDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case QUEARY:
                return new QueryDAOImpl();
            case COST:
                return new CostDAOImpl();

            default:
                return null;
        }
    }
}
