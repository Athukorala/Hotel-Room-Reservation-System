/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.controller;

import com.mangroven.hotel.controller.custom.QueryController;
import com.mangroven.hotel.controller.custom.impl.CostControllerImpl;
import com.mangroven.hotel.controller.custom.impl.FoodControllerImpl;
import com.mangroven.hotel.controller.custom.impl.Food_PackageControllerImpl;
import com.mangroven.hotel.controller.custom.impl.GuestControllerImpl;
import com.mangroven.hotel.controller.custom.impl.IDControllerImpl;
import com.mangroven.hotel.controller.custom.impl.OrderControllerImpl;
import com.mangroven.hotel.controller.custom.impl.OrderDetailControllerImpl;
import com.mangroven.hotel.controller.custom.impl.Food_Package_DetailControllerImpl;
import com.mangroven.hotel.controller.custom.impl.PasswordControllerImpl;
import com.mangroven.hotel.controller.custom.impl.PaymentControllerImpl;
import com.mangroven.hotel.controller.custom.impl.QueryControllerImpl;
import com.mangroven.hotel.controller.custom.impl.ReservationControllerImpl;
import com.mangroven.hotel.controller.custom.impl.RoomControllerImpl;
import com.mangroven.hotel.controller.custom.impl.ValidationControllerImpl;

/**
 *
 * @author tharindu
 */
public class ControllerFactory {

    public enum ControllerTypes {

        GUEST, ORDER, ORDER_DETAIL, FOOD, FOOD_PACKAGE, RESERVATION, ROOM, PASSWORD, ID, PAYMENT, FOOD_PACKAGE_DETAIL, QUERY, VALIDATION, COST;
    }

    private static ControllerFactory controllerFactory;

    private ControllerFactory() {

    }

    public static ControllerFactory getInstance() {
        if (controllerFactory == null) {
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }

    public SuperController getController(ControllerTypes controller) {
        switch (controller) {
            case GUEST:
                return new GuestControllerImpl();
            case ORDER:
                return new OrderControllerImpl();
            case FOOD:
                return new FoodControllerImpl();
            case RESERVATION:

                return new ReservationControllerImpl();
            case ROOM:
                return new RoomControllerImpl();
            case FOOD_PACKAGE:
                return new Food_PackageControllerImpl();
            case ORDER_DETAIL:
                return new OrderDetailControllerImpl();
            case PASSWORD:
                return new PasswordControllerImpl();
            case ID:
                return (SuperController) new IDControllerImpl();
            case PAYMENT:
                return new PaymentControllerImpl();
            case FOOD_PACKAGE_DETAIL:
                return new Food_Package_DetailControllerImpl();
            case QUERY:
                return new QueryControllerImpl();
            case VALIDATION:
                return new ValidationControllerImpl();
            case COST:
                return new CostControllerImpl();
            default:
                return null;
        }
    }
}
