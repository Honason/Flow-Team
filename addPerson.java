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

    public addPerson() {
        super("Add Person");
        setContentPane(rootPanel);
        rootPanel.setPreferredSize(new Dimension(400, 280));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String allInputs = "";

                if(!nameInput.getText().trim().isEmpty()) {
                    allInputs = allInputs + nameInput.getText() + ",";
                }
                if(!adminInput.getText().trim().isEmpty()) {
                    allInputs = allInputs + adminInput.getText() + ",";
                }
                if(!analystInput.getText().trim().isEmpty()) {
                    allInputs = allInputs + analystInput.getText() + ",";
                }
                if(!creativeInput.getText().trim().isEmpty()) {
                    allInputs = allInputs + creativeInput.getText() + ",";
                }
                if(!finisherInput.getText().trim().isEmpty()) {
                    allInputs = allInputs + finisherInput.getText();
                }

                String[] tempLength = allInputs.split(",");

                //Execute when button is pressed
                if(tempLength.length == 5) {
                    PersonControl.addOnePerson(allInputs);

                    setVisible(false);
                    dispose();
                }
            }
        });

        setVisible(true);
        pack();
    }
}
