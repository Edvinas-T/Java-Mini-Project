import javax.swing.*;

public class RegisterOwnershipForm {
    private JLabel motorTaxLabel;
    private JPanel PanelRegister;


    public RegisterOwnershipForm() {

    }

    void showReg(){

        JFrame Register = new JFrame("Register");
        Register.setContentPane(new RegisterOwnershipForm().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Register.pack();
        Register.setVisible(true);
        Register.setLocationRelativeTo(null);
        Register.setSize(700,500);


    }

}
