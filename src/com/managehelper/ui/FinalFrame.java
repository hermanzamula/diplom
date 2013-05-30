package com.managehelper.ui;


import com.managehelper.model.ApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;


public class FinalFrame extends Shell {


    protected Shell shell;


    /**
     * Create contents of the shell.
     */
    protected void createContents(ApplicationContext context) {
        shell = new Shell();
        setText("SWT Application");
        setSize(600, 444);

        ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setBounds(10, 10, 564, 289);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        Table table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn.setWidth(100);
        tblclmnNewColumn.setText("New Column");

        TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_1.setWidth(100);
        tblclmnNewColumn_1.setText("New Column");

        TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_2.setWidth(100);
        tblclmnNewColumn_2.setText("New Column");

        TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_3.setWidth(100);
        tblclmnNewColumn_3.setText("New Column");

        TableItem tableItem = new TableItem(table, SWT.NONE);
        tableItem.setText("New TableItem");

        TableItem tableItem_1 = new TableItem(table, SWT.NONE);
        tableItem_1.setText("New TableItem");

        TableItem tableItem_2 = new TableItem(table, SWT.NONE);
        tableItem_2.setText("New TableItem");

        TableItem tableItem_3 = new TableItem(table, SWT.NONE);
        tableItem_3.setText("New TableItem");

        TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_4.setToolTipText("");
        tblclmnNewColumn_4.setWidth(50);
        tblclmnNewColumn_4.setText("New Column");

        TableColumn tblclmnNewColumn_10 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_10.setWidth(50);
        tblclmnNewColumn_10.setText("New Column");
        scrolledComposite.setContent(table);
        scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        Table coefRate = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
        coefRate.setBounds(121, 305, 253, 49);
        coefRate.setHeaderVisible(true);
        coefRate.setLinesVisible(true);

        TableColumn tblclmnNewColumn_5 = new TableColumn(coefRate, SWT.NONE);
        tblclmnNewColumn_5.setWidth(50);
        tblclmnNewColumn_5.setText("1");

        TableColumn tblclmnNewColumn_9 = new TableColumn(coefRate, SWT.NONE);
        tblclmnNewColumn_9.setWidth(50);
        tblclmnNewColumn_9.setText("2");

        TableColumn tblclmnNewColumn_6 = new TableColumn(coefRate, SWT.NONE);
        tblclmnNewColumn_6.setWidth(50);
        tblclmnNewColumn_6.setText("3");

        TableColumn tblclmnNewColumn_8 = new TableColumn(coefRate, SWT.NONE);
        tblclmnNewColumn_8.setWidth(52);
        tblclmnNewColumn_8.setText("4");

        TableColumn tblclmnNewColumn_7 = new TableColumn(coefRate, SWT.NONE);
        tblclmnNewColumn_7.setWidth(46);
        tblclmnNewColumn_7.setText("5");

        Label lblNewLabel = new Label(this, SWT.NONE);
        lblNewLabel.setBounds(10, 317, 105, 15);
        lblNewLabel.setText("\u0412\u0435\u0441\u0430");

        Button btnEvalute = new Button(this, SWT.NONE);
        btnEvalute.setBounds(499, 370, 75, 25);
        btnEvalute.setText("Evalute");

        Table bestGroupRatesTbl = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
        bestGroupRatesTbl.setLinesVisible(true);
        bestGroupRatesTbl.setHeaderVisible(true);
        bestGroupRatesTbl.setBounds(121, 360, 253, 49);

        TableColumn tableColumn = new TableColumn(bestGroupRatesTbl, SWT.NONE);
        tableColumn.setWidth(50);
        tableColumn.setText("1");

        TableColumn tableColumn_1 = new TableColumn(bestGroupRatesTbl, SWT.NONE);
        tableColumn_1.setWidth(50);
        tableColumn_1.setText("2");

        TableColumn tableColumn_2 = new TableColumn(bestGroupRatesTbl, SWT.NONE);
        tableColumn_2.setWidth(50);
        tableColumn_2.setText("3");

        TableColumn tableColumn_3 = new TableColumn(bestGroupRatesTbl, SWT.NONE);
        tableColumn_3.setWidth(52);
        tableColumn_3.setText("4");

        TableColumn tableColumn_4 = new TableColumn(bestGroupRatesTbl, SWT.NONE);
        tableColumn_4.setWidth(46);
        tableColumn_4.setText("5");

        Label label = new Label(this, SWT.NONE);
        label.setText("\u041B\u0443\u0447\u0448\u0430\u044F \u0433\u0440\u0443\u043F\u043F\u0430");
        label.setBounds(10, 380, 105, 15);

    }


    public void open(ApplicationContext context) {
        Display display = Display.getDefault();
        shell = new Shell();
        shell.setSize(600, 447);
        shell.setText("");

        createContents(context);

        shell.setLayout(null);
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

    }
}