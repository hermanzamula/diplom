package com.managehelper.ui.frames;


import com.managehelper.model.ApplicationContext;
import com.managehelper.ui.ManageFrame;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import javax.swing.*;

import static com.managehelper.ui.UiUtils.addEditableListeners;
import static java.lang.Double.valueOf;


public class FinalFrame implements ManageFrame<ApplicationContext> {


    protected Shell shell;
    private Table coefRate;
    private Table table;

    /**
     * Create contents of the shell.
     */
    protected void createContents(final ApplicationContext context) {

        Composite scrolledComposite = new Composite(shell, SWT.NONE);
        scrolledComposite.setBounds(0, 0, 830, 300);
        /*scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);*/

        TabFolder tabFolder = new TabFolder(scrolledComposite, SWT.NONE);
        tabFolder.setBounds(0, 0, 830, 300);

        TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
        tabItem.setText("Ненормализованные");

        table = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
        tabItem.setControl(table);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        createColumns(table);
        createGroupsLine(table, context.getNumOfGroups(), context);

        TabItem noNorm = new TabItem(tabFolder, SWT.NONE);
        noNorm.setText("Нормализованные");

        Table noNormTable = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
        noNorm.setControl(noNormTable);
        noNormTable.setHeaderVisible(true);
        noNormTable.setLinesVisible(true);

        createNormTable(noNormTable);
        createNormGroupsLine(noNormTable, context.getNumOfGroups(), context);



/*
        scrolledComposite.setContent(table);
        scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));*/

        createCoefficientRateTable();

        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setBounds(10, 315, 150, 15);
        lblNewLabel.setText("Важность Критериев");

        Label lbl = new Label(shell, SWT.NONE);
        lbl.setBounds(450, 315, 330, 15);
        lbl.setText(" I - Индекс групповой сплоченности");

        Label lb2 = new Label(shell, SWT.NONE);
        lb2.setBounds(450, 335, 330, 15);
        lb2.setText(" Eg - Индекс групповой экспанисвности");

        Label lb3 = new Label(shell, SWT.NONE);
        lb3.setBounds(450, 355, 330, 15);
        lb3.setText(" Cj - Индекс социометрического статуса");

        Label lb4 = new Label(shell, SWT.NONE);
        lb4.setBounds(450, 375, 330, 15);
        lb4.setText(" Ej - Индекс эмоциональной экспансивности");

        Label lb5 = new Label(shell, SWT.NONE);
        lb5.setBounds(450, 395, 330, 15);
        lb5.setText(" R - Стоимость обучения группы");


        Button btnEvalute = new Button(shell, SWT.NONE);
        btnEvalute.setBounds(280, 363, 75, 25);
        btnEvalute.setText("Вычислить");



        btnEvalute.addSelectionListener(onEvaluatePress(context));
    }

    private void createNormGroupsLine(Table noNormTable, int numOfGroups, ApplicationContext context) {
        for (int i = 0; i < numOfGroups; i++) {
            TableItem tableItem = new TableItem(noNormTable, SWT.NONE);
            tableItem.setText("" + (i + 1));
            tableItem.setText(1, "" + context.getNormalized()[i][0]);
            tableItem.setText(2, "" + context.getNormalized()[i][1]);
            tableItem.setText(3, "" + context.getNormalized()[i][2]);
            tableItem.setText(4, "" + context.getNormalized()[i][3]);
            tableItem.setText(5, "" + context.getNormalized()[i][4]);
        }
    }

    private SelectionAdapter onEvaluatePress(final ApplicationContext context) {
        return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                final TableItem item = coefRate.getItem(0);
                for (int i = 0; i < coefRate.getColumnCount(); i++) {
                    final String text = item.getText(i).trim();
                    try{
                        final Double value = valueOf(text.isEmpty() ? "0" : text);
                        context.getWeights()[i] = value;
                    } catch (NumberFormatException NaN){
                        context.getWeights()[i] = 0;
                    }
                }

                final double[] raiting = context.getEvaluator().evaluateTeamRate(
                        context.getNumOfGroups(),
                        context.getNormalized(),
                        context.getWeights()
                );

                for(int i = 0; i < table.getItemCount(); i ++){
                    table.getItem(i).setText(7, String.valueOf(raiting[i]));
                }
            }
        };
    }

    private void createCoefficientRateTable() {

        coefRate = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        coefRate.setBounds(10, 339, 260, 50);
        coefRate.setHeaderVisible(true);
        coefRate.setLinesVisible(true);

        createTableColumn(coefRate, "I: ");
        createTableColumn(coefRate, "Eg: ");
        createTableColumn(coefRate, "Cj: ");
        createTableColumn(coefRate, "Ej: ");
        createTableColumn(coefRate, "R: ");

        TableItem tableItem = new TableItem(coefRate, SWT.NONE);
        tableItem.setText("");

        addEditableListeners(coefRate);
    }

    private void createTableColumn(Table table, String name) {
        createTableColumn(table, name, 50);
    }

    private void createGroupsLine(Table table, int count, ApplicationContext context) {
        for (int i = 0; i < count; i++) {
            TableItem tableItem = new TableItem(table, SWT.NONE);
            tableItem.setText("" + (i + 1));
            tableItem.setText(1, "" + context.getTeams().get(i).getIndex());
            tableItem.setText(2, "" + context.getTeams().get(i).getGroupUnity());
            tableItem.setText(3, "" + context.getTeams().get(i).getMedianaPlus());
            tableItem.setText(4, "" + context.getTeams().get(i).getMedianaMinus());
            tableItem.setText(5, "" + context.getTeams().get(i).getCost());
            tableItem.setText(6, "" + context.getTeams().get(i).getRating());
        }
    }

    private void createNormTable(Table normTable){
        TableColumn columnDefault = new TableColumn(normTable, SWT.NONE);
        columnDefault.setWidth(100);
        columnDefault.setText("№ Группы");

        createTableColumn(normTable, "I :", 100);
        createTableColumn(normTable, "Eg :", 100);
        createTableColumn(normTable, "Cj :", 100);
        createTableColumn(normTable, "Ej :", 100);
        createTableColumn(normTable, "R :", 100);
    }

    private void createColumns(Table table) {
        TableColumn columnDefault = new TableColumn(table, SWT.NONE);
        columnDefault.setWidth(100);
        columnDefault.setText("№ Группы");

        createTableColumn(table, "I : ", 100);
        createTableColumn(table, "Eg : ", 100);
        createTableColumn(table, "Cj : ", 100);
        createTableColumn(table, "Ej : ", 100);
        createTableColumn(table, "R :", 100);
        createTableColumn(table, "Рейтинг", 100);
        createTableColumn(table, "Общая оценка", 100);
    }

    private void createTableColumn(Table table, String name, int i) {
        TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
        tableColumn_1.setWidth(i);
        tableColumn_1.setText(name);
    }

    @Override
    public void open(ApplicationContext context) {
        Display display = Display.getDefault();
        if(shell != null){
            shell.setVisible(true);
            return;
        }
        shell = new Shell();
        shell.setSize(860, 440);
        shell.setText("Шаг 3: Вычисление Оценки");

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

    @Override
    public void close() {
        shell.dispose();
    }
}