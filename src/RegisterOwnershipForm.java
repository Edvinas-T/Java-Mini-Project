//RegisterOwnershipForm.java


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * An instantiable class which defines the RegisterOwnership Form. It contains validation and exception-handling
 * code in its KeyListeners and Actionlisteners.
 * @ Edvinas Tkacenka
 */

public class RegisterOwnershipForm {
    private JLabel registerLabel;
    private JPanel PanelRegister;
    private JTextField forenameText;
    private JLabel forenameLabel,surnameLabel,streetLabel, townLabel, countyLabel, eircodeLabel, phoneLabel, regLabel, makeLabel;
    private JComboBox makeBox;
    private JComboBox modelBox;
    private JLabel modelLabel;
    private JTextField surnameText,streetText, townText, countyText, eircodeText, phoneText, regText;
    private JButton btnSave;
    private final ArrayList<String> text = new ArrayList<>();
    private final ArrayList<JTextField> reset = new ArrayList<>();

    /**
     * The main method.
     * The empty fields are entered with user-supplied values and simple validation is done as each key is pressed.
     * The user selects a value from the Make ComboBox and the Model ComboBox.
     * Save button takes all user-supplied values and creates a new text file which adds all values in to.
     * Validation method is called from Validation.java that checks if the user-supplied fields are correct.
     */

    public RegisterOwnershipForm() {


        forenameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (forenameText.getText().length() >= 20)  //limits characters to 20
                    e.consume();

                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }

        });
        surnameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (surnameText.getText().length() >= 20)
                    e.consume();
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        streetText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (streetText.getText().length() >= 20)
                    e.consume();

            }
        });
        townText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (townText.getText().length() >= 20)
                    e.consume();
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        countyText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (countyText.getText().length() >= 20)
                    e.consume();
                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        eircodeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String eir = eircodeText.getText();

                if (eir.length() >= 7) {
                    e.consume();
                }
            }
        });

        phoneText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((phoneText.getText().length() >= 10)) {
                    e.consume();
                }

                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        regText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (regText.getText().length() >= 9)
                    e.consume();

            }
        });
        makeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modelLabel.setVisible(true);
                modelBox.setVisible(true);

                if (makeBox.getSelectedIndex() == 0) {
                    modelBox.removeAllItems();
                    modelBox.addItem("A3");
                    modelBox.addItem("A4");
                    modelBox.addItem("A5");
                }

                if (makeBox.getSelectedIndex() == 1) {
                    modelBox.removeAllItems();
                    modelBox.addItem("i3");
                    modelBox.addItem("i4 M50");
                    modelBox.addItem("X3");
                }

                if (makeBox.getSelectedIndex() == 2) {
                    modelBox.removeAllItems();
                    modelBox.addItem("Fiesta");
                    modelBox.addItem("Focus");
                    modelBox.addItem("Ranger");
                }

                if (makeBox.getSelectedIndex() == 3) {
                    modelBox.removeAllItems();
                    modelBox.addItem("i10");
                    modelBox.addItem("i20");
                    modelBox.addItem("i30");
                }

                if (makeBox.getSelectedIndex() == 4) {
                    modelBox.removeAllItems();
                    modelBox.addItem("Ceed");
                    modelBox.addItem("Picanto");
                    modelBox.addItem("Sorento");
                }

                if (makeBox.getSelectedIndex() == 5) {
                    modelBox.removeAllItems();
                    modelBox.addItem("207");
                    modelBox.addItem("208");
                    modelBox.addItem("308");
                }
            }
        });


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               Validation valid = new Validation();


               valid.textValid(forenameText,surnameText,streetText,townText,countyText,eircodeText,phoneText,regText);

                if(forenameText.getText().isEmpty() || surnameText.getText().isEmpty() || streetText.getText().isEmpty() || townText.getText().isEmpty() || countyText.getText().isEmpty() || eircodeText.getText().isEmpty() || phoneText.getText().isEmpty() || regText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Error - All info must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                text.add(forenameText.getText());
                text.add(surnameText.getText());
                text.add(streetText.getText());
                text.add(townText.getText());
                text.add(countyText.getText());
                text.add(eircodeText.getText().toUpperCase());
                text.add(phoneText.getText());
                text.add(regText.getText().toUpperCase());
                String make = (String) makeBox.getSelectedItem();
                text.add(make);
                String model = (String) modelBox.getSelectedItem();
                text.add(model);

                StringBuilder output = new StringBuilder();
                try {
                    for (Object str : text) {
                        output.append(str.toString());
                        output.append("\n");
                    }
                    try {
                        File txtfile;

                        txtfile = new File(surnameText.getText()+forenameText.getText()+".txt");
                        txtfile.createNewFile();
                        Files.write(Paths.get(txtfile.getCanonicalPath()),output.toString().getBytes(),StandardOpenOption.APPEND);  //i cant believe this works
                        JOptionPane.showMessageDialog(null,"Successfully added","Registered",JOptionPane.INFORMATION_MESSAGE);

                        valid.reset(reset,forenameText,surnameText,streetText,townText,countyText,eircodeText,phoneText,regText,makeBox,modelBox);
                        text.clear();
                    }
                    catch (IOException e1) {
                        e1.printStackTrace();   //shouldnt be an error unless destination of txt file is changed
                    }
                }
                catch (NullPointerException e1)
                {
                    JOptionPane.showMessageDialog(null,"Error - All info must be filled","Error",JOptionPane.ERROR_MESSAGE);

                }




            }
        });

    }

    /**
     * Method that is called from MotorTaxForm.
     * It displays the RegisterOwnershipForm GUI.
     */

    void showReg(){

        JFrame Register = new JFrame("Register");
        Register.setContentPane(new RegisterOwnershipForm().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.pack();
        Register.setVisible(true);
        Register.setLocationRelativeTo(null);
        Register.setSize(550,550);
        Register.setResizable(false);

    }


}
