package com.example.twu.repository.storage;

import com.example.twu.entities.Menu;

public class MenuStorage {

    private static final Menu MENU = new Menu("\n***********\n" +
            "1 login\n" +
            "2 show all book\n" +
            "3 show all movie\n" +
            "4 checkout book\n" +
            "5 checkout movie\n" +
            "6 return book\n" +
            "7 my user info\n" +
            "8 exit\n" +
            "***********\n" +
            "please choose number you want：\n");


    private static final String WELCOME_INFO = "*********** Welcome to Biblioteca! ***********";

    public static Menu getMenus() {
        return MENU;
    }

    public static String getWelcomeInfo() {
        return WELCOME_INFO;
    }
}
