package flowteam;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    public static int activeRow = 0;
    DefaultTableModel model;
    public static JTable table = new JTable(20,5);
    String col[] = {"Name","Admin. Sc.","Analyst sc.","Creative sc.","Finisher sc."};
    private JButton addButton;

    public void init() {
        model = new DefaultTableModel(col,20);
        table=new JTable(model){
            @Override public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        JScrollPane pane = new JScrollPane(table);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();

                    // do some action if appropriate column
                    System.out.println("I clicked " + row + " row and " + column + "column.");
                    new addPerson().editPerson(row, column);
                }
            }
        });

        add(pane); setVisible(true);

        addButton = new JButton();
        addButton.setText("Add Person");
        addButton.setEnabled(true);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                new addPerson().newPerson();
            }
        });
        add(addButton);

        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addCell(Person person) {
        table.setValueAt(person.getName(),activeRow,0);
        table.setValueAt(person.getAdmin(),activeRow,1);
        table.setValueAt(person.getAnalyzer(),activeRow,2);
        table.setValueAt(person.getCreator(),activeRow,3);
        table.setValueAt(person.getFinisher(),activeRow,4);
    }

    public void removeRow(int row) {
        //table.remove(0);
        ((DefaultTableModel)table.getModel()).removeRow(row);
    }

    public String getValue(int valX, int valY) {
        return table.getValueAt(valX, valY).toString();
    }
}
