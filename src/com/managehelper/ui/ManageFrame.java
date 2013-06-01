package com.managehelper.ui;


import com.managehelper.model.ApplicationContext;

public interface ManageFrame<ApplicationContext> {
    void open(ApplicationContext context);
    void close();
}
