package controller;

import model.Encryption;
import model.model.operations.AdminOp;
import model.model.operations.UserOp;
import view.Log;
import view.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerInit {
    public ControllerInit() {
        Log log=new Log();
        UserOp userOp=new UserOp();
        log.setVisible(true);
        log.getLog().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminOp adminOp=new AdminOp();


                if(adminOp.logAdmin(log.getUsernameF().getText(),log.getPasswordF().getText())==true){
                    ControllerAdmin controllerAdmin=new ControllerAdmin();
                }else if(userOp.logUser(log.getUsernameF().getText(),Encryption.encrypt(log.getPasswordF().getText()))==true){
                    ControllerUser controllerUser=new ControllerUser();
                }else{
                    throw new IllegalArgumentException();
                }
            }
        });
        log.getRegister().addActionListener(new ActionListener() {
            @Override


            public void actionPerformed(ActionEvent e) {
                RegisterView registerView=new RegisterView();
                registerView.setVisible(true);
                registerView.registerBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userOp.createUser(registerView.textFieldUsername.getText(), Encryption.encrypt(registerView.textFieldpass.getText()),registerView.textFieldEmail.getText(),registerView.textFieldPhone.getText(),registerView.textFieldAddress.getText(),registerView.textFieldCard.getText());
                        JOptionPane.showMessageDialog(registerView,"Account created! Feel free to order");
                    }
                });
            }
        });
    }
}
