import javax.swing.*;

public class UpdateOwnership {
    private JPanel PanelRegister;
    private JLabel forenameLabel,surnameLabel,streetLabel, townLabel, countyLabel, eircodeLabel, phoneLabel, regLabel, makeLabel,updateLabel;
    private JTextField forenameText,surnameText,streetText, townText, countyText, eircodeText, phoneText, regText;
    private JComboBox makeBox;
    private JComboBox modelBox;
    private JLabel modelLabel;
    private JButton btnSave;
    private JButton selectOwnerToUpdateButton;

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
