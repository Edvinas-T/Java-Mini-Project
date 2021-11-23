import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MotorTaxForm {
    private JButton registerBtn;
    private JButton renewTax;
    private JButton exitBtn;
    private JButton updateBtn;
    private JLabel motorTaxLabel;
    private JPanel panelMain;


    public MotorTaxForm() {
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"works?");
                //Jframe register = new blahblah , blahblah.setvisible , this.setvisible false
            }
        });
    }

    public static void main(String[] args) {
        JFrame MotorTax = new JFrame("Motor Tax");
        MotorTax.setContentPane(new MotorTaxForm().panelMain);
        MotorTax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MotorTax.pack();
        MotorTax.setVisible(true);
        MotorTax.setLocationRelativeTo(null);
        MotorTax.setSize(700,500);
    }


}
