/*
 * Created by JFormDesigner on Thu May 24 02:03:33 GMT+02:00 2018
 */

package view;

import model.Cart;
import model.Product;
import model.model.operations.CartOp;
import model.model.operations.ProductOp;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Silvana Man
 */
public class UserView extends JFrame {
    String columsCart[]={"ID","PRODUCT","QUANTITY"};
    String columsProd[] = {"ID", "NAME", "CATEGORY", "PRICE", "RESEALED"};

    public DefaultTableModel tableModel,tableModel1;
    public UserView() {
        initComponents();
        tableModel=new DefaultTableModel(new Object[][]{},columsCart);
        tableModel1=new DefaultTableModel(new Object[][]{},columsProd);
        setCartTable();
        setProdTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Silvana Man
        scrollPaneProd = new JScrollPane();
        tableProd = new JTable();
        scrollPanecart = new JScrollPane();
        tableCart = new JTable();
        textFieldID = new JTextField();
        textFieldCantitate = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        buttonToCart = new JButton();
        buttonRemoveProd = new JButton();
        buttonOrder = new JButton();
        textFieldremove = new JTextField();
        seeSpec = new JButton();
        logoutBtn = new JButton();
        id1 = new JTextField();
        id2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        compare = new JButton();
        history = new JButton();
        comboBox1 = new JComboBox<>();

        //======== this ========
        setTitle("Welcome!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPaneProd ========
        {
            scrollPaneProd.setViewportView(tableProd);
        }
        contentPane.add(scrollPaneProd);
        scrollPaneProd.setBounds(20, 20, scrollPaneProd.getPreferredSize().width, 270);

        //======== scrollPanecart ========
        {
            scrollPanecart.setViewportView(tableCart);
        }
        contentPane.add(scrollPanecart);
        scrollPanecart.setBounds(20, 335, scrollPanecart.getPreferredSize().width, 218);
        contentPane.add(textFieldID);
        textFieldID.setBounds(650, 35, 100, textFieldID.getPreferredSize().height);
        contentPane.add(textFieldCantitate);
        textFieldCantitate.setBounds(650, 100, 100, textFieldCantitate.getPreferredSize().height);

        //---- label1 ----
        label1.setText("ID");
        contentPane.add(label1);
        label1.setBounds(550, 40, 55, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Quantity");
        contentPane.add(label2);
        label2.setBounds(530, 100, 70, label2.getPreferredSize().height);

        //---- buttonToCart ----
        buttonToCart.setText("Add to cart");
        contentPane.add(buttonToCart);
        buttonToCart.setBounds(new Rectangle(new Point(610, 185), buttonToCart.getPreferredSize()));

        //---- buttonRemoveProd ----
        buttonRemoveProd.setText("Remove product");
        contentPane.add(buttonRemoveProd);
        buttonRemoveProd.setBounds(new Rectangle(new Point(595, 505), buttonRemoveProd.getPreferredSize()));

        //---- buttonOrder ----
        buttonOrder.setText("Order");
        contentPane.add(buttonOrder);
        buttonOrder.setBounds(new Rectangle(new Point(630, 400), buttonOrder.getPreferredSize()));
        contentPane.add(textFieldremove);
        textFieldremove.setBounds(505, 510, 65, textFieldremove.getPreferredSize().height);

        //---- seeSpec ----
        seeSpec.setText("see specification");
        contentPane.add(seeSpec);
        seeSpec.setBounds(new Rectangle(new Point(800, 35), seeSpec.getPreferredSize()));

        //---- logoutBtn ----
        logoutBtn.setText("logout");
        contentPane.add(logoutBtn);
        logoutBtn.setBounds(new Rectangle(new Point(880, 515), logoutBtn.getPreferredSize()));
        contentPane.add(id1);
        id1.setBounds(890, 145, 55, id1.getPreferredSize().height);
        contentPane.add(id2);
        id2.setBounds(890, 205, 55, id2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("ID1");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(850, 150), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("ID2");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(850, 205), label4.getPreferredSize()));

        //---- compare ----
        compare.setText("Compare");
        contentPane.add(compare);
        compare.setBounds(new Rectangle(new Point(865, 265), compare.getPreferredSize()));

        //---- history ----
        history.setText("History");
        contentPane.add(history);
        history.setBounds(new Rectangle(new Point(845, 410), history.getPreferredSize()));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "cash",
            "card"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(520, 400), comboBox1.getPreferredSize()));

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

    private void showPropertyChangeCart(PropertyChangeEvent e) {

        setCartTable();
    }

    public void setCartTable() {
        CartOp cartOp=new CartOp();
        ProductOp productOp=new ProductOp();
        tableCart.setModel(tableModel);
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        List<Cart> lista = cartOp.readMyCarts();
        for (Cart s : lista) {
            //Product product=productOp.findById(s.getIdProduct())
            Object[] objects = {s.getId(),s.getIdProduct().getName(),s.getQuantity()};
            tableModel.addRow(objects);
        }
    }

    private void showPropertyChangeProducts(PropertyChangeEvent e) {
        setProdTable();
    }

    private void setProdTable() {
        ProductOp productOp=new ProductOp();

        tableProd.setModel(tableModel1);

        for(int i=tableModel1.getRowCount()-1;i>=0;i--){
            tableModel1.removeRow(i);
        }
        List<Product> list=productOp.readProducts();
        for(Product p:list){
            Object[] objects={p.getId(),p.getName(),p.getCategory(),p.getPrice(),p.isResealed()};
            tableModel1.addRow(objects);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Silvana Man
    private JScrollPane scrollPaneProd;
    public JTable tableProd;
    private JScrollPane scrollPanecart;
    public JTable tableCart;
    public JTextField textFieldID;
    public JTextField textFieldCantitate;
    private JLabel label1;
    private JLabel label2;
    public JButton buttonToCart;
    public JButton buttonRemoveProd;
    public JButton buttonOrder;
    public JTextField textFieldremove;
    public JButton seeSpec;
    public JButton logoutBtn;
    public JTextField id1;
    public JTextField id2;
    private JLabel label3;
    private JLabel label4;
    public JButton compare;
    public JButton history;
    public JComboBox<String> comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
