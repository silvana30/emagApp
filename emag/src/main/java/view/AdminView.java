/*
 * Created by JFormDesigner on Thu May 24 00:40:24 GMT+02:00 2018
 */

package view;

import model.Product;
import model.User;
import model.model.operations.ProductOp;
import model.model.operations.UserOp;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Silvana Man
 */
public class AdminView extends JFrame {
    String columsProd[] = {"ID", "NAME", "CATEGORY", "PRICE", "RESEALED"};
    String columsUser[] = {"ID", "USERNAME", "PASSWORD", "EMAIL","PHONE","CARD_NR","ADDRESS","LOYAL"};
    //String columsCart[]={"ID","PRODUCT","QUANTITY"};
    public DefaultTableModel tableModel1,tableModel2,tableModel3;
    public AdminView() {
        initComponents();
        tableModel1=new DefaultTableModel(new Object[][]{},columsProd);
        tableModel2=new DefaultTableModel(new Object[][]{},columsUser);

        setProdTable();
        setUserTable();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Silvana Man
        scrollPaneProducts = new JScrollPane();
        tableProducts = new JTable();
        label1 = new JLabel();
        priceProd = new JTextField();
        label2 = new JLabel();
        nameProd = new JTextField();
        label3 = new JLabel();
        category = new JComboBox<>();
        resealed = new JCheckBox();
        specificationBtn = new JButton();
        scrollPane1 = new JScrollPane();
        tableUsers = new JTable();
        idUser = new JTextField();
        buttonloyal = new JButton();
        buttonaddProd = new JButton();
        label4 = new JLabel();
        idDelete = new JTextField();
        deleteBtn = new JButton();
        label5 = new JLabel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPaneProducts ========
        {
            scrollPaneProducts.setViewportView(tableProducts);
        }
        contentPane.add(scrollPaneProducts);
        scrollPaneProducts.setBounds(10, 15, 455, 380);

        //---- label1 ----
        label1.setText("Name:");
        contentPane.add(label1);
        label1.setBounds(500, 15, 110, 21);
        contentPane.add(priceProd);
        priceProd.setBounds(635, 60, 155, priceProd.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Price:");
        contentPane.add(label2);
        label2.setBounds(500, 65, 110, 21);
        contentPane.add(nameProd);
        nameProd.setBounds(635, 15, 155, nameProd.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Category:");
        contentPane.add(label3);
        label3.setBounds(500, 115, 110, 21);

        //---- category ----
        category.setModel(new DefaultComboBoxModel<>(new String[] {
            "laptop",
            "phone"
        }));
        contentPane.add(category);
        category.setBounds(635, 110, 155, category.getPreferredSize().height);

        //---- resealed ----
        resealed.setText("resealed");
        contentPane.add(resealed);
        resealed.setBounds(new Rectangle(new Point(655, 155), resealed.getPreferredSize()));

        //---- specificationBtn ----
        specificationBtn.setText("Add specification");
        contentPane.add(specificationBtn);
        specificationBtn.setBounds(new Rectangle(new Point(635, 200), specificationBtn.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableUsers);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 410, scrollPane1.getPreferredSize().width, 260);

        //---- idUser ----
        idUser.setText("ID");
        contentPane.add(idUser);
        idUser.setBounds(580, 500, 75, idUser.getPreferredSize().height);

        //---- buttonloyal ----
        buttonloyal.setText("set loyal");
        contentPane.add(buttonloyal);
        buttonloyal.setBounds(new Rectangle(new Point(510, 565), buttonloyal.getPreferredSize()));

        //---- buttonaddProd ----
        buttonaddProd.setText("Add product");
        contentPane.add(buttonaddProd);
        buttonaddProd.setBounds(new Rectangle(new Point(645, 260), buttonaddProd.getPreferredSize()));

        //---- label4 ----
        label4.setText("ID user");
        contentPane.add(label4);
        label4.setBounds(505, 505, 65, label4.getPreferredSize().height);
        contentPane.add(idDelete);
        idDelete.setBounds(530, 335, 35, idDelete.getPreferredSize().height);

        //---- deleteBtn ----
        deleteBtn.setText("DELETE");
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(new Rectangle(new Point(605, 330), deleteBtn.getPreferredSize()));

        //---- label5 ----
        label5.setText("ID:");
        contentPane.add(label5);
        label5.setBounds(490, 340, 30, label5.getPreferredSize().height);

        //---- button1 ----
        button1.setText("log out");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(790, 620), button1.getPreferredSize()));

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

    public void showPropertyChangeUsers(PropertyChangeEvent e) {
    setUserTable();

    }

    public void setUserTable() {
        UserOp userOp=new UserOp();

        tableUsers.setModel(tableModel2);
        for (int i = tableModel2.getRowCount() - 1; i >= 0; i--) {
            tableModel2.removeRow(i);
        }
        List<User> list=userOp.readUsers();
        for(User u:list){
            Object[] objects={u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getCardNr(),u.getPhone(),u.getAddress(),u.isLoyal()};
            tableModel2.addRow(objects);
        }
    }

    public void showPropertyChangeProducts(PropertyChangeEvent e) {
        setProdTable();
    }

    public void setProdTable() {
        ProductOp productOp=new ProductOp();

        tableProducts.setModel(tableModel1);

        for(int i=tableModel1.getRowCount()-1;i>=0;i--){
            tableModel1.removeRow(i);
        }
        List<Product> list=productOp.readProducts();
        for(Product p:list){
            Object[] objects={p.getId(),p.getName(),p.getCategory(),p.getPrice(),p.isResealed()
            };
            tableModel1.addRow(objects);
        }



    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Silvana Man
    private JScrollPane scrollPaneProducts;
    public JTable tableProducts;
    private JLabel label1;
    public JTextField priceProd;
    private JLabel label2;
    public JTextField nameProd;
    private JLabel label3;
    public JComboBox<String> category;
    public JCheckBox resealed;
    public JButton specificationBtn;
    private JScrollPane scrollPane1;
    public JTable tableUsers;
    public JTextField idUser;
    public JButton buttonloyal;
    public JButton buttonaddProd;
    private JLabel label4;
    public JTextField idDelete;
    public JButton deleteBtn;
    private JLabel label5;
    public JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
