package controller;

import model.Product;
import model.Specification;
import model.model.operations.ProductOp;
import model.model.operations.UserOp;
import view.AdminView;
import view.SpecificationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControllerAdmin {
    public ControllerAdmin() {
        AdminView adminView = new AdminView();

        ProductOp productOp = new ProductOp();
        UserOp userOp=new UserOp();

        adminView.setVisible(true);
        adminView.buttonaddProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Product product=new Product(adminView.nameProd.getText(),Integer.parseInt(adminView.priceProd.getText()),adminView.category.getSelectedItem().toString(),adminView.resealed.isSelected());
                productOp.createProduct(adminView.nameProd.getText(), Integer.parseInt(adminView.priceProd.getText()), adminView.category.getSelectedItem().toString(), adminView.resealed.isSelected());
                adminView.setProdTable();
            }
        });

        adminView.specificationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecificationView specificationView = new SpecificationView();
                specificationView.setVisible(true);
                specificationView.doneSpec.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int newId = productOp.getMaxIdProd() + 1;
                        productOp.createSpecification(newId, specificationView.processor.getText(), specificationView.screen.getText(), specificationView.ram.getText(), specificationView.hdd.getText(), specificationView.video.getText(), specificationView.color.getText(), specificationView.camera.getText());

                    }
                });
            }
        });

        adminView.deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productOp.deleteProduct(Integer.parseInt(adminView.idDelete.getText()));
                adminView.setProdTable();
            }
        });


        adminView.buttonloyal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userOp.makeLoyal(Integer.parseInt(adminView.idUser.getText()));
                JOptionPane.showMessageDialog(adminView,"This client is now loyal.");
            }
        });
        adminView.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.setVisible(false);
            }
        });


    }
}
