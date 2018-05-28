/*
 * Created by JFormDesigner on Sun May 27 15:31:40 GMT+02:00 2018
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author Silvana Man
 */
public class RegisterView extends JFrame {
    public RegisterView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Silvana Man
        textFieldUsername = new JTextField();
        textFieldpass = new JTextField();
        textFieldEmail = new JTextField();
        textFieldPhone = new JTextField();
        textFieldAddress = new JTextField();
        textFieldCard = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        registerBtn = new JButton();

        //======== this ========
        setTitle("Register now!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textFieldUsername);
        textFieldUsername.setBounds(230, 30, 115, textFieldUsername.getPreferredSize().height);
        contentPane.add(textFieldpass);
        textFieldpass.setBounds(230, 85, 115, textFieldpass.getPreferredSize().height);
        contentPane.add(textFieldEmail);
        textFieldEmail.setBounds(230, 135, 115, textFieldEmail.getPreferredSize().height);
        contentPane.add(textFieldPhone);
        textFieldPhone.setBounds(230, 190, 115, textFieldPhone.getPreferredSize().height);
        contentPane.add(textFieldAddress);
        textFieldAddress.setBounds(230, 240, 115, textFieldAddress.getPreferredSize().height);
        contentPane.add(textFieldCard);
        textFieldCard.setBounds(230, 285, 115, textFieldCard.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Password");
        contentPane.add(label1);
        label1.setBounds(115, 90, 85, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Email");
        contentPane.add(label2);
        label2.setBounds(115, 140, 85, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Phone");
        contentPane.add(label3);
        label3.setBounds(115, 195, 85, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Address");
        contentPane.add(label4);
        label4.setBounds(115, 245, 85, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Card number");
        contentPane.add(label5);
        label5.setBounds(115, 290, 105, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("Username");
        contentPane.add(label6);
        label6.setBounds(115, 30, 85, label6.getPreferredSize().height);

        //---- registerBtn ----
        registerBtn.setText("Register");
        contentPane.add(registerBtn);
        registerBtn.setBounds(new Rectangle(new Point(230, 355), registerBtn.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Silvana Man
    public JTextField textFieldUsername;
    public JTextField textFieldpass;
    public JTextField textFieldEmail;
    public JTextField textFieldPhone;
    public JTextField textFieldAddress;
    public JTextField textFieldCard;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    public JButton registerBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
