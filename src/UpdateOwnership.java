import javax.swing.*;

public class UpdateOwnership {
    private JPanel PanelRegister;
    private JLabel motorTaxLabel;
    private JLabel surnameLabel;
    private JLabel streetLabel;
    private JLabel townLabel;
    private JLabel countyLabel;
    private JLabel forenameLabel;
    private JLabel eircodeLabel;
    private JLabel phoneLabel;
    private JLabel regLabel;
    private JLabel makeLabel;
    private JTextField forenameText;
    private JTextField surnameText;
    private JTextField streetText;
    private JTextField townText;
    private JTextField countyText;
    private JTextField eircodeText;
    private JTextField regText;
    private JComboBox makeBox;
    private JComboBox modelBox;
    private JLabel modelLabel;
    private JFormattedTextField phoneText;
    private JButton btnSave;

    void showUpdateReg(){

        JFrame Register = new JFrame("Update");
        Register.setContentPane(new UpdateOwnership().PanelRegister);
        Register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Register.pack();
        Register.setVisible(true);
        Register.setLocationRelativeTo(null);
        Register.setSize(550,500);
}
}
