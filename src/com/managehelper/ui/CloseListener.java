package com.managehelper.ui;


import com.managehelper.model.ApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class CloseListener implements Listener {

    private Shell shell;
    private ApplicationContext context;

    CloseListener(Shell shell, ApplicationContext context) {
        this.shell = shell;
        this.context = context;
    }

    @Override
    public void handleEvent(Event event) {
        int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
        MessageBox messageBox = new MessageBox(shell, style);
        messageBox.setText("Внимание");
        messageBox.setMessage("Выйти из программы?");
        final int open = messageBox.open();
        event.doit = open == SWT.YES;
        if (open == SWT.YES) {
            context.setError(true);
        }
    }
}
