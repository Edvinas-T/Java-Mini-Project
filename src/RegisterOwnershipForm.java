import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterOwnershipForm {
    private JLabel motorTaxLabel;
    private JPanel PanelRegister;
    private JTextField forenameText;
    private JLabel forenamePanel;
    private JLabel surnamePanel;
    private JLabel streetPanel;
    private JLabel townPanel;
    private JLabel countyPanel;
    private JLabel eircodePanel;
    private JLabel phonePanel;
    private JLabel regPanel;
    private JLabel makePanel;
    private JComboBox makeBox;
    private JComboBox modelBox;
    private JLabel modelPanel;
    private JTextField surenameText;
    private JTextField streetText;
    private JTextField townText;
    private JTextField countyText;
    private JTextField eircodeText;
    private JTextField phoneText;
    private JTextField regText;


    public RegisterOwnershipForm() {

        forenameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(forenameText.getText().length()>= 20)  //limits characters to 20
                    e.consume();
            }
        });
        surenameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(surenameText.getText().length()>= 20)  //limits characters to 20
                    e.consume();
            }
        });
        streetText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(streetText.getText().length()>= 20)  //limits characters to 20
                    e.consume();
            }
        });
        townText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(townText.getText().length()>= 20)  //limits characters to 20
                    e.consume();
            }
        });
        countyText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(countyText.getText().length()>= 20)  //limits characters to 20
                    e.consume();
            }
        });
        eircodeText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(eircodeText.getText().length()>= 7)  //limits characters to 20
                    e.consume();

            }
        });
        phoneText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                boolean digitOnly; // digit only fix this
                if(phoneText.getText().length()>= 10)  //limits characters to 20
                    e.consume();
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
