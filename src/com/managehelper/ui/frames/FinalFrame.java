package com.managehelper.ui.frames;


import com.managehelper.model.ApplicationContext;
import com.managehelper.ui.ManageFrame;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

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

        ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setBounds(10, 10, 830, 300);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        createColumns(table);
        createGroupsLine(table, context.getNumOfGroups(), context);


        scrolledComposite.setContent(table);
        scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        createCoefficientRateTable();

        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setBounds(10, 315, 150, 15);
        lblNewLabel.setText("Важность Критериев");

        Button btnEvalute = new Button(shell, SWT.NONE);
        btnEvalute.setBounds(280, 363, 75, 25);
        btnEvalute.setText("Вычислить");

        btnEvalute.addSelectionListener(onEvaluatePress(context));
    }

    private SelectionAdapter onEvaluatePress(final ApplicationContext context) {
        return new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                final TableItem item = coefRate.getItem(0);
                for (int i = 0; i < coefRate.getColumnCount(); i++) {
                    final String text = item.getText(i).trim();
                    context.getWeights()[i] = valueOf(text.isEmpty() ? "0" : text);
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

        createTableColumn(coefRate, "A");
        createTableColumn(coefRate, "I");
        createTableColumn(coefRate, "Ms+");
        createTableColumn(coefRate, "Ms-");
        createTableColumn(coefRate, "R");

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

    private void createColumns(Table table) {
        TableColumn columnDefault = new TableColumn(table, SWT.NONE);
        columnDefault.setWidth(100);
        columnDefault.setText("№ Группы");

        createTableColumn(table, "A", 100);
        createTableColumn(table, "I", 100);
        createTableColumn(table, "Ms+", 100);
        createTableColumn(table, "Ms-", 100);
        createTableColumn(table, "R", 100);
        createTableColumn(table, "Q", 100);
        createTableColumn(table, "P", 100);
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