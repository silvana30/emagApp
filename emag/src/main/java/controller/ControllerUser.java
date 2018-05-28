package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import model.model.operations.CartOp;
import model.model.operations.OrderOp;
import model.model.operations.ProductOp;
import model.model.operations.UserOp;
import org.hibernate.criterion.Order;
import view.MyOrders;
import view.SpecificationView2;
import view.UserView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class ControllerUser extends Observable{
    public ControllerUser() {
        UserView userView = new UserView();
        userView.setVisible(true);
        CartOp cartOp = new CartOp();
        UserOp userOp = new UserOp();
        OrderOp orderOp = new OrderOp();
        ProductOp productOp = new ProductOp();
        userView.buttonToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartOp.createCart(Integer.parseInt(userView.textFieldCantitate.getText()), Integer.parseInt(userView.textFieldID.getText()));
                userView.setCartTable();
            }
        });

        userView.logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userOp.logout();
                userView.setVisible(false);
            }
        });

        userView.buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userView.comboBox1.getSelectedItem().toString().equals("card")){
                    JOptionPane.showMessageDialog(userView,"Please, confirm that you want to use your credit card.");
                    orderOp.createOrder();

                    JOptionPane.showMessageDialog(userView,"Order sent");
                    generateReport();
                    //User user=userOp.getLogged();
                    Admin admin=new Admin();

                    addObserver(admin);
                    setChanged();
                    notifyObservers("New order!");}
                else{
                orderOp.createOrder();

                JOptionPane.showMessageDialog(userView,"Order sent");
                generateReport();
                //User user=userOp.getLogged();
                Admin admin=new Admin();

                addObserver(admin);
                setChanged();
                notifyObservers("New order!");}

                //sendMail();
            }
        });

        userView.buttonRemoveProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartOp.removeCart(Integer.parseInt(userView.textFieldremove.getText()));
                userView.setCartTable();

            }
        });

        userView.seeSpec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecificationView2 specificationView2 = new SpecificationView2();
                specificationView2.setVisible(true);
                String[] col = {"", ""};
                DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][]{}, col);
                Specification specification = productOp.getSpecification(Integer.parseInt(userView.textFieldID.getText()));
                Object[] row1 = {"Processor", specification.getProcessor()};
                Object[] row2 = {"Screen size", specification.getScreenSize()};
                Object[] row3 = {"RAM", specification.getRam()};
                Object[] row4 = {"HDD", specification.getHdd()};
                Object[] row5 = {"Video card", specification.getVideoCard()};
                Object[] row6 = {"Color", specification.getColor()};
                Object[] row7 = {"Camera", specification.getCamera()};
                defaultTableModel.addRow(row1);
                defaultTableModel.addRow(row2);
                defaultTableModel.addRow(row3);
                defaultTableModel.addRow(row4);
                defaultTableModel.addRow(row5);
                defaultTableModel.addRow(row6);
                defaultTableModel.addRow(row7);

                specificationView2.tableSpec.setModel(defaultTableModel);
            }
        });

        userView.compare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpecificationView2 specificationView2 = new SpecificationView2();
                specificationView2.setVisible(true);
                Product product = productOp.findById(Integer.parseInt(userView.id1.getText()));
                Product product2 = productOp.findById(Integer.parseInt(userView.id2.getText()));

                String[] col = {"", product.getName(), product2.getName()};
                DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][]{}, col);
                Specification specification = productOp.getSpecification(Integer.parseInt(userView.id1.getText()));
                Specification specification2 = productOp.getSpecification(Integer.parseInt(userView.id1.getText()));

                Object[] row1 = {"Processor", specification.getProcessor(), specification2.getProcessor()};
                Object[] row2 = {"Screen size", specification.getScreenSize(), specification2.getScreenSize()};
                Object[] row3 = {"RAM", specification.getRam(), specification2.getRam()};
                Object[] row4 = {"HDD", specification.getHdd(), specification2.getHdd()};
                Object[] row5 = {"Video card", specification.getVideoCard(), specification2.getVideoCard()};
                Object[] row6 = {"Color", specification.getColor(), specification2.getColor()};
                Object[] row7 = {"Camera", specification.getCamera(), specification2.getCamera()};
                defaultTableModel.addRow(row1);
                defaultTableModel.addRow(row2);
                defaultTableModel.addRow(row3);
                defaultTableModel.addRow(row4);
                defaultTableModel.addRow(row5);
                defaultTableModel.addRow(row6);
                defaultTableModel.addRow(row7);

                specificationView2.tableSpec.setModel(defaultTableModel);
            }
        });

        userView.history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyOrders myOrders=new MyOrders();
                myOrders.setVisible(true);
                DefaultTableModel model = new DefaultTableModel(new Object[][] {},
                        new String[] {"Id Order", "Date", "Address","Total Price"});
                for(int i=model.getRowCount()-1;i>=0;i--){
                    model.removeRow(i);
                }

                List<OrderP> lista=orderOp.readMyOrders();
                System.out.println(lista.toString());
                Object[] row;
                for(OrderP c:lista){
                    row=new Object[]{""+c.getId()+"",c.getPlacementDate(),c.getUser().getAddress(),c.getTotalPrice()};
                    model.addRow(row);
                }
                myOrders.tableHistory.setModel(model);
            }
        });
    }
    public static void generateReport(){
        OrderOp orderOp = new OrderOp();
        UserOp userOp=new UserOp();
        User user=userOp.getLogged();

        List<OrderP> lista=orderOp.readMyOrders();

        OrderP lastOrder=orderOp.getLastOrder();
        File myFile = new File("report"+user.getUsername()+".txt");
        try(PrintWriter writer = new PrintWriter(myFile))
        {


            writer.println(lastOrder.toString());

            writer.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.toString());
        }

    }
    public static void sendMail(){
        // Recipient's email ID needs to be mentioned.
        String to = "silvana.man30@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "silva30reghin@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port","2525");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


}
