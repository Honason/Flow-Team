package flowteam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPerson extends JFrame {
    private JTextField nameInput;
    private JTextField adminInput;
    private JTextField analystInput;
    private JTextField creativeInput;
    private JTextField finisherInput;
    private JLabel nameLabel;
    private JLabel adminLabel;
    private JLabel analystLabel;
    private JLabel creativeLabel;
    private JLabel finisherLabel;
    private JPanel rootPanel;
    private JButton saveButton;
    private JButton delButton;

    public addPerson() {
        super("Add or edit person");
        setContentPane(rootPanel);
        rootPanel.setPreferredSize(new Dimension(300, 350));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void newPerson() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String allInputs = checkInputs();
                if(allInputs != "") {
                    PersonControl.addOnePerson(allInputs);
                    setVisible(false);
                    dispose();
                }
            }
        });
        remove(delButton);
        setVisible(true);
        pack();
    }

    public void editPerson(final int row, final int column) {
        System.out.println("" + Main.userInterface.getValue(row, column));

        nameInput.setText(Main.userInterface.getValue(row, 0));
        adminInput.setText(Main.userInterface.getValue(row, 1));
        analystInput.setText(Main.userInterface.getValue(row, 2));
        creativeInput.setText(Main.userInterface.getValue(row, 3));
        finisherInput.setText(Main.userInterface.getValue(row, 4));

        saveButton.setText("Save changes");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String allInputs = checkInputs();
                if(allInputs != "") {
                    Main.userInterface.activeRow = row;
                    PersonControl.editOnePerson(allInputs);
                    setVisible(false);
                    dispose();
                }
            }
        });

        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.userInterface.activeRow = row;

                Main.userInterface.removeRow(row);
                PersonControl.removeOnePerson();
                setVisible(false);
                dispose();
            }
        });
        setVisible(true);
        pack();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public String checkInputs() {
        String allInputs = "";

        if(!nameInput.getText().trim().isEmpty()) {
            allInputs = allInputs + nameInput.getText() + ",";
        }
        if(!adminInput.getText().trim().isEmpty() && isInteger(adminInput.getText()) && Integer.parseInt(adminInput.getText())<=30) {
            allInputs = allInputs + adminInput.getText() + ",";
        } else {
            System.out.println("Your administrator score must be integer lower or equal to 30.");
        }
        if(!analystInput.getText().trim().isEmpty() && isInteger(analystInput.getText()) && Integer.parseInt(analystInput.getText())<=30) {
            allInputs = allInputs + analystInput.getText() + ",";
        } else {
            System.out.println("Your analyst score must be integer lower or equal to 30.");
        }
        if(!creativeInput.getText().trim().isEmpty() && isInteger(creativeInput.getText()) && Integer.parseInt(creativeInput.getText())<=30) {
            allInputs = allInputs + creativeInput.getText() + ",";
        } else {
            System.out.println("Your creative score must be integer lower or equal to 30.");
        }
        if(!finisherInput.getText().trim().isEmpty() && isInteger(finisherInput.getText()) && Integer.parseInt(finisherInput.getText())<=30) {
            allInputs = allInputs + finisherInput.getText();
        } else {
            System.out.println("Your finisher score must be integer lower or equal to 30.");
        }

        String[] tempLength = allInputs.split(",");

        if(tempLength.length != 5) {
            allInputs = "";
            System.out.println("------------------------------------------------");
        }

        return allInputs;
    }
}
