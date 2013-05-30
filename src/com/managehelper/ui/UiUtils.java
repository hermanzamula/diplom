package com.managehelper.ui;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import java.lang.reflect.Method;

public class UiUtils {

    public static void addMouseListener(final Table table, final TableCursor cursor, final ControlEditor editor) {
        cursor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseUp(MouseEvent e) {
                final Text text = new Text(cursor, SWT.NONE);
                TableItem row = cursor.getRow();
                final int column = cursor.getColumn();
                row.getText(column);
                text.setText(row.getText(column));
                text.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        TableItem row = cursor.getRow();
                        int column = cursor.getColumn();
                        row.setText(column, text.getText());
                        // close the text editor when the user hits "ESC"
                        if (e.character == SWT.ESC) {
                            text.dispose();
                        }
                    }
                });
                // close the text editor when the user clicks away
                text.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent e) {
                        final TableItem item = cursor.getRow();
                        item.setText(column, text.getText());
                        text.dispose();
                    }
                });
                editor.setEditor(text);
                text.setFocus();
            }
        });
    }

    public static void addEditableListeners(Table table) {
        final TableCursor cursor = new TableCursor(table, SWT.NONE);
        final ControlEditor editor = new ControlEditor(cursor);
        editor.grabHorizontal = true;
        editor.grabVertical = true;

        addMouseListener(table, cursor, editor);
        addSelectionListener(table, cursor, editor);
    }

    public static void addSelectionListener(final Table table, final TableCursor cursor, final ControlEditor editor) {
        cursor.addSelectionListener(new SelectionAdapter() {
            // when the TableEditor is over a cell, select the corresponding row in
            // the table
            public void widgetSelected(SelectionEvent e) {
                table.setSelection(new TableItem[]{cursor.getRow()});
            }

            // when the user hits "ENTER" in the TableCursor, pop up a text editor so that
            // they can change the text of the cell
            public void widgetDefaultSelected(SelectionEvent e) {
                final Text text = new Text(cursor, SWT.NONE);
                TableItem row = cursor.getRow();
                int column = cursor.getColumn();
                text.setText(row.getText(column));
                text.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        TableItem row = cursor.getRow();
                        int column = cursor.getColumn();
                        row.setText(column, text.getText());
                        // close the text editor when the user hits "ESC"
                        if (e.character == SWT.ESC) {
                            text.dispose();
                        }
                    }
                });
                editor.setEditor(text);
                text.setFocus();
            }
        });
    }

    //http://stackoverflow.com/questions/9465732/swt-custom-row-height-on-empty-tables-trees
    public static void setCustomHeight(Table table, int height) {
        table.pack();
        try {
/*
 * Locate the method setItemHeight(int). Note that if you do not
 * have access to the method, you must use getDeclaredMethod(). If
 * setItemHeight(int) were public, you could simply call
 * getDeclaredMethod.
 */
            Method setItemHeightMethod =
                    table.getClass().getDeclaredMethod("setItemHeight", int.class);

/*
 * Set the method as accessible. Again, this would not be necessary
 * if setItemHeight(int) were public.
 */
            setItemHeightMethod.setAccessible(true);

/*
 * Invoke the method. Equivalent to table.setItemHeight(50).
 */
            setItemHeightMethod.invoke(table, height);
        } catch (Exception e) {
/*
 * Reflection failed, it's probably best to swallow the exception and
 * degrade gracefully, as if we never called setItemHeight.  Maybe
 * log the error or print the exception to stderr?
 */
            e.printStackTrace();
        }
    }
}
