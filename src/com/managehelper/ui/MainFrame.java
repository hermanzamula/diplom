package com.managehelper.ui;


import com.managehelper.model.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainFrame {


    public static void main(String[] args) {
        try {
            final ApplicationContext context = new ApplicationContext();
            context.getManager().init(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
