package com.managehelper.ui;

import com.managehelper.model.ApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import static java.lang.Integer.valueOf;

public class InputFrame implements ManageFrame{

    protected Shell shell;
    private Text groupNumText;
    private Text participantNumText;


    @Override
    public void open(final ApplicationContext context) {
        Display display = Display.getDefault();
        shell = new Shell();
        shell.setSize(450, 300);
        shell.setText("");
        shell.setLayout(null);
        createContents(context);

        shell.open();
        shell.layout();

        shell.addListener(SWT.Close, new CloseListener(shell, context));

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents(final ApplicationContext context) {
        final Label groupNum = new Label(shell, SWT.NONE);
        groupNum.setBounds(10, 45, 63, 15);
        groupNum.setText("Введите количество групп");

        groupNumText = new Text(shell, SWT.BORDER);
        groupNumText.setBounds(283, 42, 76, 21);

        Label participantNum = new Label(shell, SWT.NONE);
        participantNum.setBounds(10, 92, 87, 15);
        participantNum.setText("Введите количество претендентов");

        participantNumText = new Text(shell, SWT.BORDER);
        participantNumText.setBounds(283, 89, 76, 21);

        Button btnContinue = new Button(shell, SWT.NONE);
        btnContinue.setBounds(363, 226, 61, 25);
        btnContinue.setText("Продолжить");

        btnContinue.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                if (groupNumText.getText().trim().isEmpty() || participantNumText.getText().trim().isEmpty()) {
                    return;
                }
                context.setNumOfGroups(valueOf(groupNumText.getText()));
                context.setNumOfParticipants(valueOf(participantNumText.getText()));
                shell.dispose();
            }
        });

    }

}