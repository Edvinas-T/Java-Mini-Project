import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class RegisterOwnershipForm {
    private JLabel motorTaxLabel;
    private JPanel PanelRegister;
    private JTextField forenameText;
    private JLabel forenameLabel;
    private JLabel surnameLabel;
    private JLabel streetLabel;
    private JLabel townLabel;
    private JLabel countyLabel;
    private JLabel eircodeLabel;
    private JLabel phoneLabel;
    private JLabel regLabel;
    private JLabel makeLabel;
    private JComboBox makeBox;
    private JComboBox modelBox;
    private JLabel modelLabel;
    private JTextField surnameText;
    private JTextField streetText;
    private JTextField townText;
    private JTextField countyText;
    private JTextField eircodeText;
    private JTextField phoneText;
    private JTextField regText;

   // ArrayList<String> make = new ArrayList<String>();



    public RegisterOwnershipForm() {

       // make.add("BMW"); make.add("Audi"); make.add("Ford");
       // make.add("Mazda"); make.add("Peugeot"); make.add("Kia");



        forenameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(forenameText.getText().length()>= 20)  //limits characters to 20
                    e.consume();
            }
        });
        surnameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(surnameText.getText().length()>= 20)
                    e.consume();
            }
        });
        streetText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(streetText.getText().length()>= 20)
                    e.consume();
            }
        });
        townText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(townText.getText().length()>= 20)
                    e.consume();
            }
        });
        countyText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(countyText.getText().length()>= 20)
                    e.consume();
            }
        });
        eircodeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(eircodeText.getText().length()>= 7)
                    e.consume();

            }
        });

        phoneText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))
                {
                    e.consume();
                }
            }
        });
        regText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                if(regText.getText().length()>= 9)
                    e.consume();
                //8 to 9 chars - first 2/3 must be digits 3
            }
        });
        makeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modelLabel.setVisible(true);
                modelBox.setVisible(true);

                if(makeBox.getSelectedIndex()==0)
                {
                    modelBox.removeAllItems();
                    modelBox.addItem("A3");
                    modelBox.addItem("A4");
                    modelBox.addItem("A5");
                }

                if(makeBox.getSelectedIndex()==1)
                {
                    modelBox.removeAllItems();
                    modelBox.addItem("i3");
                    modelBox.addItem("i4 M50");
                    modelBox.addItem("X3");
                }

                if(makeBox.getSelectedIndex()==2)
                {
                    modelBox.removeAllItems();
                    modelBox.addItem("Fiesta");
                    modelBox.addItem("Focus");
                    modelBox.addItem("Ranger");
                }

                if(makeBox.getSelectedIndex()==3)
                {
                    modelBox.removeAllItems();
                    modelBox.addItem("i10");
                    modelBox.addItem("i20");
                    modelBox.addItem("i30");
                }

                if(makeBox.getSelectedIndex()==4)
                {
                    modelBox.removeAllItems();
                    modelBox.addItem("Ceed");
                    modelBox.addItem("Picanto");
                    modelBox.addItem("Sorento");
                }

                if(makeBox.getSelectedIndex()==5)
                {
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

    void showReg(){

        JFrame Register = new JFrame("Register");
        Register.setContentPane(new RegisterOwnershipForm().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.pack();
        Register.setVisible(true);
        Register.setLocationRelativeTo(null);
        Register.setSize(550,500);


    }


}
