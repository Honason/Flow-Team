package flowteam;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        add(pane); setVisible(true);

        addButton = new JButton();
        addButton.setText("Add Person");
        addButton.setEnabled(true);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Execute when button is pressed
                new addPerson();
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
}
