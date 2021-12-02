import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


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
    private BufferedReader reader = null;
    private ArrayList<String> list= new ArrayList<>();
    Validation valid = new Validation();
    private ArrayList<String> text = new ArrayList<>();

    public UpdateOwnership() {

        selectOwnerToUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                makeBox.removeAllItems();
                modelBox.removeAllItems();

                OwnerChooser = new JFileChooser("./");
                OwnerChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text","txt","text");
                OwnerChooser.setAcceptAllFileFilterUsed(false);
                OwnerChooser.setFileFilter(filter);

                OwnerChooser.setDialogTitle("Which owner do you want to update");
                int result = OwnerChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {

                    file = OwnerChooser.getSelectedFile();
                    try{
                        reader = new BufferedReader(new FileReader(file));

                        String str;
                        while((str = reader.readLine()) != null){
                            list.add((str));

                        }


                        forenameText.setText(list.get(0));
                        surnameText.setText(list.get(1));
                        streetText.setText(list.get(2));
                        townText.setText(list.get(3));
                        countyText.setText(list.get(4));
                        eircodeText.setText(list.get(5));
                        phoneText.setText(list.get(6));
                        regText.setText(list.get(7));
                        makeBox.addItem(list.get(8));
                        modelBox.addItem(list.get(9));


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

                char c = e.getKeyChar();
                if (!((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }

            }
        });
        surnameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(surnameText.getText().length() >= 20)
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


            }
        });
        modelBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Validation valid = new Validation();
                valid.textValid(forenameText,surnameText,streetText,townText,countyText,eircodeText,phoneText,regText);


                text.add(forenameText.getText());
                text.add(surnameText.getText());
                text.add(streetText.getText());
                text.add(townText.getText());
                text.add(countyText.getText());
                text.add(eircodeText.getText());
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

                        Files.write(Paths.get(txtfile.getCanonicalPath()),output.toString().getBytes(), StandardOpenOption.APPEND);  //i cant believe this works
                        JOptionPane.showMessageDialog(null,"Successfully added","Registered",JOptionPane.INFORMATION_MESSAGE);


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

    void showUpdateReg(){

        JFrame Register = new JFrame("Update");
        Register.setContentPane(new UpdateOwnership().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.pack();
        Register.setVisible(true);
        Register.setLocationRelativeTo(null);
        Register.setSize(550,550);
        Register.setResizable(false);
}
}
