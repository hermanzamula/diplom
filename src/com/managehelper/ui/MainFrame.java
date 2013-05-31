package com.managehelper.ui;


import com.managehelper.model.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainFrame {


    public static void main(String[] args) {
        try {
            final ApplicationContext context = new ApplicationContext();
            InputFrame window = new InputFrame();

            window.open(context);
            //TODO: сделать адекватную обработку закрытия окна
            if(context.isError()){
                return;
            }
            //Next window
            TableFrame tableFrame = new TableFrame();
            tableFrame.open(context);

            if(context.isError()){
                return;
            }
            //Final window
            FinalFrame finalFrame = new FinalFrame();
            finalFrame.open(context);
            System.out.println("aaaa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
