/*
 * Created by JFormDesigner on Mon May 28 01:38:05 GMT+02:00 2018
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author Silvana Man
 */
public class MyOrders extends JFrame {
    public MyOrders() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Silvana Man
        scrollPane1 = new JScrollPane();
        tableHistory = new JTable();

        //======== this ========
        setTitle("History");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableHistory);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 5, scrollPane1.getPreferredSize().width, 265);

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
    private JScrollPane scrollPane1;
    public JTable tableHistory;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
