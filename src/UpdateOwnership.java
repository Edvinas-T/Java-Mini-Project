import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UpdateOwnership {
    private JPanel PanelRegister;
    private JLabel forenameLabel,surnameLabel,streetLabel, townLabel, countyLabel, eircodeLabel, phoneLabel, regLabel, makeLabel,updateLabel;
    private JTextField forenameText,surnameText,streetText, townText, countyText, eircodeText, phoneText, regText;
    private JComboBox makeBox;
    private JComboBox modelBox;
    private JLabel modelLabel;
    private JButton btnSave;
    private JButton selectOwnerToUpdateButton;
    private JFileChooser OwnerChooser;
    private File file;
    public UpdateOwnership() {

        selectOwnerToUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OwnerChooser = new JFileChooser("./");
                OwnerChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text","txt","text");
                OwnerChooser.setAcceptAllFileFilterUsed(false);
                OwnerChooser.setFileFilter(filter);

                OwnerChooser.setDialogTitle("Which owner do you want to update");
                int result = OwnerChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {

                    file = OwnerChooser.getSelectedFile();
                    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                        List<String> infoTextFields = new ArrayList<>();
                        infoTextFields = Files.readAllLines(file.toPath()); //https://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist
                                                                            //https://stackoverflow.com/questions/22873417/choosing-a-txt-file-with-jfilechooser-and-making-it-appear-on-a-jtextfield-just
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }


                }

            }});

        forenameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (forenameText.getText().length() >= 20)  //limits characters to 20
                    e.consume();

            }
        });
        surnameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (surnameText.getText().length() >= 20)
                    e.consume();
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
            }
        });
        countyText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (countyText.getText().length() >= 20)
                    e.consume();
            }
        });
        eircodeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String eir = eircodeText.getText();
                char input = e.getKeyChar();
                if (eir.length() >= 7) {
                    e.consume();

                }

                /*if(!Character.isDigit(eir.charAt(0))){
                    e.consume();    //fix validation here
                }*/
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
                //8 to 9 chars - first 2/3 must be digits 3
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
        modelBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

    }

    void showUpdateReg(){

        JFrame Register = new JFrame("Update");
        Register.setContentPane(new UpdateOwnership().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.pack();
        Register.setVisible(true);
        Register.setLocationRelativeTo(null);
        Register.setSize(550,550);
}
}
