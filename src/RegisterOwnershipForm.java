import javax.swing.*;

public class RegisterOwnershipForm {
    private JLabel motorTaxLabel;
    private JPanel PanelRegister;

    public RegisterOwnershipForm() {

    }

    public static void main(String[] args) {
        JFrame Register = new JFrame("Register Ownership");
        Register.setContentPane(new RegisterOwnershipForm().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Register.pack();

        Register.setLocationRelativeTo(null);
        Register.setSize(700,500);
    }
}
