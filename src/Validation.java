import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Validation {

    public void textValid(JTextField field,JTextField field1,JTextField field2,JTextField field3,JTextField field4,JTextField field5,JTextField field6,JTextField field7)
    {

        if(field.getText().length()>20){
        {
            JOptionPane.showMessageDialog(null,"Forename must not be more than 20 characters","Error",JOptionPane.ERROR_MESSAGE);
            field.setText("");
        }
        }
        if(field1.getText().length()>20)
        {
            JOptionPane.showMessageDialog(null,"Surname must not be more than 20 characters","Error",JOptionPane.ERROR_MESSAGE);
            field1.setText("");
        }
        if(field2.getText().length()>20)
        {
            JOptionPane.showMessageDialog(null,"Street must not be more than 20 characters","Error",JOptionPane.ERROR_MESSAGE);
            field2.setText("");
        }
        if(field3.getText().length()>20)
        {
            JOptionPane.showMessageDialog(null,"Town must not be more than 20 characters","Error",JOptionPane.ERROR_MESSAGE);
            field3.setText("");
        }
        if(field4.getText().length()>20)
        {
            JOptionPane.showMessageDialog(null,"County must not be more than 20 characters","Error",JOptionPane.ERROR_MESSAGE);
            field4.setText("");
        }
        if(!(field5.getText().length() ==7))
        {
            JOptionPane.showMessageDialog(null,"Eircode must be 7 characters","Error",JOptionPane.ERROR_MESSAGE);
            field5.setText("");
        }

        if(field6.getText().length()>10)
        {
            JOptionPane.showMessageDialog(null,"Phone number must not be more than 10 characters","Error",JOptionPane.ERROR_MESSAGE);
            field6.setText("");
        }
        if(field7.getText().length()>9 || field7.getText().length()<=7)
        {
            JOptionPane.showMessageDialog(null,"Registration Number must be 7 to 9 characters","Error",JOptionPane.ERROR_MESSAGE);
            field7.setText("");
        }


    }
    public void reset(ArrayList<JTextField> reset,JTextField field,JTextField field1,JTextField field2,
                      JTextField field3,JTextField field4,
                      JTextField field5,JTextField field6,JTextField field7,JComboBox make,JComboBox model)
    {
        reset.add(field);
        reset.add(field1);
        reset.add(field2);
        reset.add(field3);
        reset.add(field4);
        reset.add(field5);
        reset.add(field6);
        reset.add(field7);

        for(JTextField dulfield : reset){
            dulfield.setText("");
        }

        make.setSelectedIndex(-1);
        model.setSelectedIndex(-1);


    }

    }

