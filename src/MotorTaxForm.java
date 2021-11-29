import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MotorTaxForm{
    private JButton registerBtn;
    private JButton renewTax;
    private JButton exitBtn;
    private JButton updateBtn;
    private JLabel motorTaxLabel;
    private JPanel panelMain;
    RegisterOwnershipForm Register = new RegisterOwnershipForm();
    UpdateOwnership Update = new UpdateOwnership();

     public MotorTaxForm() {

        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {

                Register.showReg();


            }
        });

         exitBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         });
         updateBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 Update.showUpdateReg();

             }
         });
     }


    public void mainPage() {
        JFrame mainPage = new JFrame("Motor Tax");
        mainPage.setContentPane(new MotorTaxForm().panelMain);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.pack();
        mainPage.setVisible(true);
        mainPage.setLocationRelativeTo(null);
        mainPage.setSize(700,500);

    }

}
